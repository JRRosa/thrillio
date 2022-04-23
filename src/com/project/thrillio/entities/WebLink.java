package com.project.thrillio.entities;

public class WebLink extends Bookmark {
    
    private String url;
    private String hostl;

    public String getUrl() {
        return url;
    }
    public String getHostl() {
        return hostl;
    }
    public void setHostl(String hostl) {
        this.hostl = hostl;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", hostl=" + hostl + "]";
	}
}
