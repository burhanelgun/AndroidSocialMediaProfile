package com.example.challange3.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("profilePhoto")
@Expose
private String profilePhoto;
@SerializedName("coverPhoto")
@Expose
private String coverPhoto;
@SerializedName("id")
@Expose
private String id;
@SerializedName("name")
@Expose
private String name;
@SerializedName("email")
@Expose
private String email;
@SerializedName("bio")
@Expose
private String bio;

public String getProfilePhoto() {
return profilePhoto;
}

public void setProfilePhoto(String profilePhoto) {
this.profilePhoto = profilePhoto;
}

public String getCoverPhoto() {
return coverPhoto;
}

public void setCoverPhoto(String coverPhoto) {
this.coverPhoto = coverPhoto;
}

public String getId() {
return id;
}

public void setId(String id) {
this.id = id;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getBio() {
return bio;
}

public void setBio(String bio) {
this.bio = bio;
}

}