package iduimian.api.client.sample.dto;

/**
 * 删除照片库api所返回的对象.
 */
public class DeleteLibRtnDto extends RtnDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4807218279014809177L;

	public DeleteLibRtnDto() {
		super(ResultCode.OK);
	}

	public DeleteLibRtnDto(ResultCode code) {
		super(code);
	}
}
