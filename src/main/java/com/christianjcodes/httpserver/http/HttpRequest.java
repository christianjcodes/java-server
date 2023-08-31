package com.christianjcodes.httpserver.http;

public class HttpRequest extends HttpMessage {

    private HttpMethod method;
    private String requestTarget;
    private String httpVersion;

    HttpRequest() {

    }

    public HttpMethod getMethod() {
        return method;
    }

    void setMethod(String methodName) throws HttpParsingException {
        for (HttpMethod method: HttpMethod.values()) {
            if (methodName.equals(method.name())) {
                this.method = method;
                return;
            }
        }

        throw new HttpParsingException(
                HttpStatusCode.SERVER_ERROR_501_NOT_IMPLEMENTED
        );
    }

    void setRequestTarget(String requestTarget) throws HttpParsingException {
        if (requestTarget == null || requestTarget.isEmpty()) {
            throw new HttpParsingException(HttpStatusCode.CLIENT_ERROR_400_BAD_REQUEST);
        }
        this.requestTarget = requestTarget;
    }
}
