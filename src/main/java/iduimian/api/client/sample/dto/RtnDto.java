package iduimian.api.client.sample.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public class RtnDto implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8334630828902105012L;
    private ResultCode result;

    public RtnDto() {
        this.result = ResultCode.OK;
    }

    public RtnDto(ResultCode e) {
        this.result = e;
    }

    /**
     * 获得api执行结果.
     *
     * @return 0： OK; 大于0： Error Code
     */
    public ResultCode getResult() {
        return result;
    }

    /**
     * 设置api执行结果. b
     *
     * @param result
     *            0： OK; 大于0： Error Code
     */
    public void setResult(ResultCode result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }


    public enum ResultCode {
		OK(0),
		SERVICE_NOT_AVAILABLE(100),
		IMAGE_LIB_ALREADY_EXISTS(101),
		IMAGE_LIB_NOT_FOUND(102),
		IMAGE_KEY_NOT_FOUND(103),
		IMAGE_SIZE_NOT_FIT(104),
		IMAGE_PROCESSING_ERROR(105),
		FACE_NOT_FOUND(106),
		ILLEGAL_ARGUMENT(107)

		 ;


		private int value;

		private ResultCode(int value) {
			this.value = value;
		}

		@JsonValue
		public int getValue() {
			return value;
		}

		@JsonCreator
		public static ResultCode forValue(int value) {
			for (final ResultCode e : ResultCode.values()) {
				if (value == e.getValue()) {
					return e;
				}
			}
			throw new IllegalArgumentException();
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this);
		}

	}
}
