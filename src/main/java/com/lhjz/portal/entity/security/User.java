package com.lhjz.portal.entity.security;

// default package
// Generated May 6, 2015 11:39:38 AM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lhjz.portal.entity.Channel;
import com.lhjz.portal.entity.Chat;
import com.lhjz.portal.entity.Project;
import com.lhjz.portal.entity.Schedule;
import com.lhjz.portal.entity.Translate;
import com.lhjz.portal.pojo.Enum.Status;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name = "users")
public class User implements java.io.Serializable, Comparable<User> {

	/** serialVersionUID long */
	private static final long serialVersionUID = -5501393570981445761L;
	@Id
	@Column(name = "username", unique = true, nullable = false, length = 50)
	private String username;

	@JsonIgnore
	@Column(name = "password", nullable = false, length = 255)
	private String password;

	private String mails;

	private String name;

	private String creator;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status = Status.Normal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLoginDate;

	private String loginRemoteAddress;

	private long loginCount = 0;

	private String resetPwdToken;

	@Temporal(TemporalType.TIMESTAMP)
	private Date resetPwdDate;

	@Version
	private long version;

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "user_project", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "project_id") })
	private Set<Project> projects = new HashSet<Project>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.REMOVE)
	private Set<Authority> authorities = new HashSet<Authority>(0);

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "watcher_project", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "project_id") })
	private Set<Project> watcherProjects = new HashSet<Project>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "watcher_translate", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "translate_id") })
	private Set<Translate> watcherTranslates = new HashSet<Translate>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "voter_chat", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "chat_id") })
	private Set<Chat> voterChats = new HashSet<Chat>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "member_channel", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "channel_id") })
	private Set<Channel> joinChannels = new HashSet<Channel>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "actor_schedule", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = { @JoinColumn(name = "schedule_id") })
	private Set<Schedule> actSchedules = new HashSet<Schedule>();

	public User() {
	}

	public User(String username) {
		this.username = username;
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, boolean enabled,
			Set<Authority> authorities) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public Set<Authority> getAuthorities() {
		return this.authorities;
	}

	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}

	public String getMails() {
		return mails;
	}

	public void setMails(String mails) {
		this.mails = mails;
	}

	public Set<Project> getProjects() {
		return projects;
	}

	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Project> getWatcherProjects() {
		return watcherProjects;
	}

	public void setWatcherProjects(Set<Project> watcherProjects) {
		this.watcherProjects = watcherProjects;
	}

	public Set<Translate> getWatcherTranslates() {
		return watcherTranslates;
	}

	public void setWatcherTranslates(Set<Translate> watcherTranslates) {
		this.watcherTranslates = watcherTranslates;
	}

	public Set<Chat> getVoterChats() {
		return voterChats;
	}

	public void setVoterChats(Set<Chat> voterChats) {
		this.voterChats = voterChats;
	}

	public Date getLastLoginDate() {
		return lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLoginRemoteAddress() {
		return loginRemoteAddress;
	}

	public void setLoginRemoteAddress(String loginRemoteAddress) {
		this.loginRemoteAddress = loginRemoteAddress;
	}

	public long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(long loginCount) {
		this.loginCount = loginCount;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getResetPwdToken() {
		return resetPwdToken;
	}

	public void setResetPwdToken(String resetPwdToken) {
		this.resetPwdToken = resetPwdToken;
	}

	public Date getResetPwdDate() {
		return resetPwdDate;
	}

	public void setResetPwdDate(Date resetPwdDate) {
		this.resetPwdDate = resetPwdDate;
	}

	public Set<Channel> getJoinChannels() {
		return joinChannels;
	}

	public void setJoinChannels(Set<Channel> joinChannels) {
		this.joinChannels = joinChannels;
	}

	public Set<Schedule> getActSchedules() {
		return actSchedules;
	}

	public void setActSchedules(Set<Schedule> actSchedules) {
		this.actSchedules = actSchedules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", mails=" + mails + ", name=" + name + ", creator="
				+ creator + ", enabled=" + enabled + ", status=" + status
				+ ", createDate=" + createDate + ", lastLoginDate="
				+ lastLoginDate + ", loginRemoteAddress=" + loginRemoteAddress
				+ ", loginCount=" + loginCount + ", resetPwdToken="
				+ resetPwdToken + ", resetPwdDate=" + resetPwdDate
				+ ", version=" + version + "]";
	}

	@Override
	public int compareTo(User o) {
		return getUsername().compareTo(o.getUsername());
	}

}
