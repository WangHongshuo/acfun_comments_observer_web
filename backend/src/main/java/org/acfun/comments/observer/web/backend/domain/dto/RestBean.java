package org.acfun.comments.observer.web.backend.domain.dto;

import java.util.HashMap;

public class RestBean extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    private static final String TAG_CODE = "code";
    private static final String TAG_MSG = "msg";
    private static final String TAG_DATA = "data";
    private static final String TAG_SUCCESS = "success";

    private RestBean(int code, boolean success, String msg, Object data) {
        super.put(TAG_CODE, code);
        super.put(TAG_SUCCESS, success);
        super.put(TAG_MSG, msg);
        super.put(TAG_DATA, data);
    }

    public static RestBean success() {
        return new RestBean(200, true, null, null);
    }

    public static RestBean success(Object data) {
        return new RestBean(200, true, null, data);
    }

    public static RestBean success(String msg, Object data) {
        return new RestBean(200, true, msg, data);
    }

    public static RestBean failure(int code) {
        return new RestBean(code, false, null, null);
    }

    public static RestBean failure(int code, String msg) {
        return new RestBean(code, false, msg, null);
    }

    @Override
    public RestBean put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
