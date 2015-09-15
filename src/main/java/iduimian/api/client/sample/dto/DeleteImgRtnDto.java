package iduimian.api.client.sample.dto;

/**
 * 删除照片api所返回的对象.
 */
public class DeleteImgRtnDto extends RtnDto {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 4807218279014809177L;

    public DeleteImgRtnDto() {
        super(ResultCode.OK);
    }

    public DeleteImgRtnDto(ResultCode code) {
        super(code);
    }
}
