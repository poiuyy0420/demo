package blog.demo.common.domain;

import blog.demo.common.code.CodeEnum;

public class BaseResult<T> {
    /**
     * 결과 코드 </br>
     */
    private String code;
    /**
     *상태
     */
    private boolean status;
    /**
     * 결과 메세지 </br>
     */
    private String message;
    /**
     * 결과 데이터 </br>
     */
    private T data;

    /**
     * constructor
     * @param resCodeEnum
     */
    public BaseResult(CodeEnum resCodeEnum) {
        this.code = resCodeEnum.getCode();
        this.message = resCodeEnum.getDesc();
        this.status = CodeEnum.SUCCESS.equals(resCodeEnum) ? true : false;
    }

    /**
     * Instantiates a new Base result.
     * @param data
     * @param resCodeEnum
     */
    public BaseResult(T data, CodeEnum resCodeEnum) {
        this.data = data;
        this.code = resCodeEnum.getCode();
        this.message = resCodeEnum.getDesc();
        this.status = CodeEnum.SUCCESS.equals(resCodeEnum) ? true : false;
    }

    /**
     * Instantiates a new Base result.
     * @param data
     * @param resCodeEnum
     * @param status
     */
    public BaseResult(T data, CodeEnum resCodeEnum, boolean status) {
        this.data = data;
        this.code = resCodeEnum.getCode();
        this.message = resCodeEnum.getDesc();
        this.status = status;
    }

    public BaseResult(CodeEnum resCodeEnum, String message) {
        this.code = resCodeEnum.getCode();
        this.message = message;
        this.status = CodeEnum.SUCCESS.equals(resCodeEnum) ? true : false;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public T getData() {
        return this.data;
    }

    public String getCode() {
        return code;
    }

    public boolean isStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

}
