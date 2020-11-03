package com.ydv.xpm;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
	
	private Page page;
	private Version version;
	private PageUpdate pageUpdate;


    private Components[] components;
  

	private String _id;
	@JsonProperty
	private boolean isActive;
	@JsonProperty
	private boolean isArchived;
	private String name;
	private String pageUrl;
	private String pageId;
	private String createdAt;
	private String updatedAt;
	private Number __v;



	private Number[] channel;
	private String status;
	private String startDate;
	private Number order;

    private String  id;
    private String label;
    private Params[] params;
    private String kind;

	private String value;
	private String parent;
    
    
    
    
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}











	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Version getVersion() {
		return version;
	}

	public void setVersion(Version version) {
		this.version = version;
	}

	public PageUpdate getPageUpdate() {
		return pageUpdate;
	}

	public void setPageUpdate(PageUpdate pageUpdate) {
		this.pageUpdate = pageUpdate;
	}






	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}


	public boolean getisActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public boolean getisArchived() {
		return isArchived;
	}

	public void setArchived(boolean archived) {
		isArchived = archived;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPageUrl() {
		return pageUrl;
	}

	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Number get__v() {
		return __v;
	}

	public void set__v(Number __v) {
		this.__v = __v;
	}



	public Number[] getChannel() {
		return channel;
	}

	public void setChannel(Number[] channel) {
		this.channel = channel;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Number getOrder() {
		return order;
	}

	public void setOrder(Number order) {
		this.order = order;
	}



	public boolean isArchived() {
		return isArchived;
	}


	
	
	public boolean isActive() {
		return isActive;
	}



	public Components[] getComponents() {
		return components;
	}

	public void setComponents(Components[] components) {
		this.components = components;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Params[] getParams() {
		return params;
	}

	public void setParams(Params[] params) {
		this.params = params;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getParent() {
		return parent;
	}

	public void setParent(String parent) {
		this.parent = parent;
	} 
}
