package iduimian.api.client.sample.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 创建照片库api所返回的对象
 */
public class Score implements Serializable {

	private static final long serialVersionUID = 4379662862951648833L;
	private String img_id;
	private float score;

	public Score() {
	}

	public Score(String img_id, float point) {
		this.img_id = img_id;
		this.score = point;
	}

	public String getImg_id() {
		return img_id;
	}

	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
