package iduimian.api.client.sample.dto;

/**
 * 创建照片库api所返回的对象
 */
public class RegistImgRtnDto extends RtnDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -152389416725005215L;

	private String img_id;

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}
}
