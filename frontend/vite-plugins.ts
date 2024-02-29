import { execSync } from 'child_process';

// 在index.html文件头中插入git信息
export async function vitePluginAddGitInfoToIndexHeader() {
  const res = await getGitInfo()
  const jsonStr = JSON.stringify(res)
  return {
    name: 'vite-plugin-git-info',
    async transformIndexHtml() {
      return [
        {
          tag: 'script',
          attrs: { defer: true },
          children: `window.GIT_INFO=${jsonStr}`,
          inject: 'head'
        }
      ]
    }
  }
}

const BRANCH_COMMAND = 'git rev-parse --abbrev-ref HEAD';
const LAST_COMMIT_HASH_COMMAND = 'git rev-parse HEAD';
const LAST_COMMIT_MSG_COMMAND = 'git log -1 --pretty=format:%s';

const runGitCommand = async (command: string) => {
  try {
    const stdout = execSync(command).toString().trim();
    return stdout
  } catch (error) {
    console.error(`fail to run git command: ${error}`)
    return 'fail to run git command'
  }
}

const getGitInfo = async () => {
  try {
    return {
      branch: await runGitCommand(BRANCH_COMMAND),
      lastCommitHash: await runGitCommand(LAST_COMMIT_HASH_COMMAND),
      lastCommitMsg: await runGitCommand(LAST_COMMIT_MSG_COMMAND)
    }
  } catch (error) {
    console.error(`fail to get git commit info: ${error}`)
  }
}
// END
