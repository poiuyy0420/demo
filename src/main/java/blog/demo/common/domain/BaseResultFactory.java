package blog.demo.common.domain;

import blog.demo.common.code.CodeEnum;

public class BaseResultFactory {

    private static BaseResultFactory instance = new BaseResultFactory();

    /**
     * 성공관련 결과 객체 반환 <br/>
     * @param <T> the type parameter
     * @param t   BaseModel클래스를상속받고있는모델클래스
     * @return BaseResult<T>   base result
     */
    public static <T> BaseResult<T> create(T t) {
        return instance.internalCreate(t);
    }

    /**
     * 기본 성공
     *
     * @param <T> the type parameter
     * @return the base result
     */
    public static <T> BaseResult<T> create() {
        return instance.internalCreate(CodeEnum.SUCCESS);
    }

    /**
     * 예외처리발생 결과 객체 반환 <br/>
     *
     * @param <T>      the type parameter
     * @param codeEnum 예외코드
     * @return BaseResult<T>   base result
     */
    public static <T> BaseResult<T> create(CodeEnum codeEnum) {
        return instance.internalCreate(codeEnum);
    }


    /**
     *  결과 객체 반환
     * @param codeEnum
     * @param data
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> create(CodeEnum codeEnum,  Object data ) {
        return instance.internalCreate(codeEnum, (T) data);
    }

    public static <T> BaseResult<T> create(CodeEnum codeEnum,  String message ) {
        return instance.internalCreate(codeEnum, message);
    }

    /**
     * CodeEnum, Data, status 결과 객체 반환
     * @param codeEnum
     * @param data
     * @param status
     * @param <T>
     * @return
     */
    public static <T> BaseResult<T> create(CodeEnum codeEnum,  Object data, boolean status) {
        return instance.internalCreate(codeEnum, (T) data, status);
    }

    /**
     * CodeEnum, Data, status 전달 받은 Method
     * @param codeEnum
     * @param t
     * @param status
     * @param <T>
     * @return
     */
    private <T> BaseResult<T> internalCreate(CodeEnum codeEnum, T  t, boolean status) {
        return new BaseResult<>(t, codeEnum, status);
    }

    /**
     * CodeEnum과 Data 전달 받은 Method
     * @param codeEnum
     * @param t
     * @param <T>
     * @return
     */
    private <T> BaseResult<T> internalCreate(CodeEnum codeEnum , T  t) {
        return new BaseResult<>(t, codeEnum);
    }

    /**
     *  CodeEnum만 전달 받은 Method
     * @param codeEnum
     * @param <T>
     * @return
     */
    private <T> BaseResult<T> internalCreate(CodeEnum codeEnum) {
        return new BaseResult<>(codeEnum);
    }

    /**
     * 결과에 대한 기본값은 성공을 전제로 한다.
     * 2017. 7. 6., bhkwon@foodtechkorea.com
     *
     * @param t
     * @param <T>
     * @return
     */
    private <T> BaseResult<T> internalCreate(T t) {
        return new BaseResult<>(t, CodeEnum.SUCCESS);
    }

    private <T> BaseResult<T> internalCreate(CodeEnum codeEnum , String message) {
        return new BaseResult<>(codeEnum, message);
    }

}
