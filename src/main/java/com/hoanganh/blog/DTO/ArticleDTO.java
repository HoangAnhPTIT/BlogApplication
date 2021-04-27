package com.hoanganh.blog.DTO;

public class ArticleDTO {
	private Long id;
	
	private String description;
	
	private String content;
	
	private Integer like;
	
	private Integer share;
	
	private String image;

	private Long userId;

	private Long[] ids;
	
	public ArticleDTO() {
		
	}
	
	public ArticleDTO(Long id, String description, String content, Long userId) {
		this.id = id;
		this.description = description;
		this.content = content;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}

	public Integer getLike() {
		return like;
	}

	public void setLike(Integer like) {
		this.like = like;
	}

	public Integer getShare() {
		return share;
	}

	public void setShare(Integer share) {
		this.share = share;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
}
