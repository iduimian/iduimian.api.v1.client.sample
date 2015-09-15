package iduimian.api.client.sample.dto;

/**
 * 创建照片库api所返回的对象.
 */
public class LibStatusRtnDto extends RtnDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5950165799139815905L;

	private long img_count;
	private long total_size;

	public long getImg_count() {
		return img_count;
	}

	public void setImg_count(long img_count) {
		this.img_count = img_count;
	}

	public long getTotal_size() {
		return total_size;
	}

	public void setTotal_size(long total_size) {
		this.total_size = total_size;
	}

	public enum LibStatus {
		OK, NONE
	}

}
