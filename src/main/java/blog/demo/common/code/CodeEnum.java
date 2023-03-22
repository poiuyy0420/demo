package blog.demo.common.code;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum CodeEnum {
    SUCCESS(1, "200", "Success", "", ""),
    UNKNOWN_EXCEPTION(2, "501", "알 수 없는 오류가 발생하였습니다.", "ERROR", "A"),
    DB_EXCEPTION(3, "503", "DB 처리에 알 수 없는 오류가 발생하였습니다", "ERROR", "A"),
    BIND_FAIL(4, "503", "Validation 맞지 않습니다", "ERROR", "A"),
    RUNTIME_EXCEPTION(5, "501", "Runtime exception!", "ERROR", "A"),
    API_FAIL(6, "402", "API 요청 중 에러가 발생했습니다", "WARN", "B");


    private static final Map<Integer, CodeEnum> flagToCodeEnum = new HashMap<>();

    private int flag;
    private String code;
    private String desc;
    private String type;
    private String grade;

    CodeEnum(int flag, String code, String desc, String type, String grade) {
        this.flag = flag;
        this.code = code;
        this.desc = desc;
        this.type = type;
        this.grade = grade;
    }

}
