package com.project.thrillio.entities;

import com.project.thrillio.partner.Shareable;

public class WebLink extends Bookmark implements Shareable{
    
    private String url;
    private String host;

    public String getUrl() {
        return url;
    }
    public String getHost() {
        return host;
    }
    public void setHost(String host) {
        this.host = host;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    
	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}
    @Override
    public boolean isKidFriendlyEligible() {
        return !("porn".contains(url) || "porn".contains(getTitle()) || "adult".contains(host));
    }
	@Override
	public String getItemData() {
		StringBuilder builder = new StringBuilder();
		builder.append("<item>");
			builder.append("<type>WebLink</type>");
			builder.append("<title>").append(getTitle()).append("</title>");
			builder.append("<url>").append(url).append("</url>");
			builder.append("<host>").append(host).append("</host>");
		builder.append("</item>");
		return builder.toString();
	}
}
