package fr.duchess.model;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@PrimaryKeyClass
public class UserActivityTimestamp implements Serializable {

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    @NotNull
    private String user_id;

    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
    @NotNull
    private String activity;

    @NotNull
    private Long timestamp;

    public UserActivityTimestamp(){
        //default constructor
    }

    public UserActivityTimestamp(String user_id, String activity, Long timestamp) {
        this.user_id = user_id;
        this.activity = activity;
        this.timestamp = timestamp;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
