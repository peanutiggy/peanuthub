package team.tjusw.elm.jdbc_proj.dao;
@SuppressWarnings("unused")
public enum StatusCode {

    OK(200, "OK", "请求已经成功处理"),
    CREATED(201, "Created", "请求已经成功处理，并创建了资源"),
    BAD_REQUEST(400, "Bad Request", "请求错误，请修正请求"),
    UNAUTHORIZED(401, "Unauthorized", "没有被授权或者授权已经失效"),
    FORBIDDEN(403, "Forbidden", "请求被理解，但是拒绝执行"),
    NOT_FOUND(404, "Not Found", "资源未找到"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed", "请求方法不允许被执行"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required", "请通过代理进行身份验证"),
    REQUEST_TIMEOUT(408, "Request Timeout", "请求超时"),
    CONFLICT(409, "Conflict", "请求冲突"),
    GONE(410, "Gone", "请求的资源不可用"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error", "服务器内部错误");

    
    
	private final int code;
	private final String enMessage;
	private final String zhMessage;
    StatusCode(int code, String enMessage, String zhMessage) {
        this.code = code;
        this.enMessage = enMessage;
        this.zhMessage = zhMessage;
    }
}