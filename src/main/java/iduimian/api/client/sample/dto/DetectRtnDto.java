package iduimian.api.client.sample.dto;

import java.util.List;

/**
 * 创建照片库api所返回的对象
 */
public class DetectRtnDto extends RtnDto {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -152389416725005215L;

	private int img_width;
	private int img_height;
	private List<Rectangle> heads;
	private List<Rectangle> faces;

	public int getImg_width() {
		return img_width;
	}

	public void setImg_width(int img_width) {
		this.img_width = img_width;
	}

	public int getImg_height() {
		return img_height;
	}

	public void setImg_height(int img_height) {
		this.img_height = img_height;
	}

	public List<Rectangle> getHeads() {
		return heads;
	}

	public void setHeads(List<Rectangle> heads) {
		this.heads = heads;
	}

	public List<Rectangle> getFaces() {
		return faces;
	}

	public void setFaces(List<Rectangle> faces) {
		this.faces = faces;
	}

}
