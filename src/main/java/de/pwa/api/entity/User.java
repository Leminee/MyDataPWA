package de.pwa.api.entity;

import java.util.Date;

import javax.persistence.*;

import de.pwa.api.elasticsearch.Indices;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Data
@Entity
@Table(name = "user")
@Document(indexName = Indices.INDEX)
@Setting(settingPath = "static/settings.json")
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Field(type = FieldType.Keyword)
    private long id;

    @Column(name = "email_address", nullable = false, unique = true)
    @Field(type = FieldType.Text)
    private String email;

    @Column(name = "mobile", nullable = false)
    @Field(type = FieldType.Text)
    private String mobile;

    @Column(name = "password", nullable = false)
    @Field(type = FieldType.Text)
    private String password;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false)
    @Field(type = FieldType.Text)
    private Date createdAt;
}