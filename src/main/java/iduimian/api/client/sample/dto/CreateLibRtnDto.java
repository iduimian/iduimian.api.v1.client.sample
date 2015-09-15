package iduimian.api.client.sample.dto;

/**
 * 创建照片库api所返回的对象
 */
public class CreateLibRtnDto extends RtnDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8603517605163421948L;

	private String lib_name;

	public CreateLibRtnDto() {
		super(ResultCode.OK);
	}

	public CreateLibRtnDto(ResultCode code) {
		super(code);
	}

	/**
	 * 获得照片库的名字.
	 *
	 * @return 照片库的名字
	 */
	public String getLib_name() {
		return lib_name;
	}

	/**
	 * 设置照片库的名字.
	 *
	 * @param lib_name
	 *            - 照片库的名字
	 */
	public void setLib_name(String lib_name) {
		this.lib_name = lib_name;
	}

}
