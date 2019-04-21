package app.entity;

import net.sf.jsefa.csv.annotation.CsvDataType;
import net.sf.jsefa.csv.annotation.CsvField;

import javax.persistence.*;
import java.util.Date;


@Entity(name = "session")
@Table(name = "session")
@CsvDataType()
public class SessionInfo {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "ssoid")
    @CsvField(pos = 1)
    private String ssoid;

    @Column(name = "ts")
    @CsvField(pos = 2)
    private Long ts;

    @Column(name = "grp")
    @CsvField(pos = 3)
    private String grp;

    @Column(name = "type")
    @CsvField(pos = 4)
    private String type;

    @Column(name = "subtype")
    @CsvField(pos = 5)
    private String subtype;

    @Column(name = "url")
    @CsvField(pos = 6)
    private String url;

    @Column(name = "orgid")
    @CsvField(pos = 7)
    private String orgid;

    @Column(name = "formid")
    @CsvField(pos = 8)
    private String formid;

    @Column(name = "code")
    @CsvField(pos = 9)
    private String code;

    @Column(name = "ltpa")
    @CsvField(pos = 10)
    private String ltpa;

    @Column(name = "sudirresponse")
    @CsvField(pos = 11)
    private String sudirresponse;

    @Column(name = "ymdh")
    @CsvField(pos = 12, format = "yyyy-mm-dd-hh")
    private Date ymdh;

    public String getSsoid() {
        return ssoid;
    }

    public void setSsoid(String ssoid) {
        this.ssoid = ssoid;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getFormid() {
        return formid;
    }

    public void setFormid(String formid) {
        this.formid = formid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLtpa() {
        return ltpa;
    }

    public void setLtpa(String ltpa) {
        this.ltpa = ltpa;
    }

    public String getSudirresponse() {
        return sudirresponse;
    }

    public void setSudirresponse(String sudirresponse) {
        this.sudirresponse = sudirresponse;
    }

    public Date getYmdh() {
        return ymdh;
    }

    public void setYmdh(Date ymdh) {
        this.ymdh = ymdh;
    }

    public SessionInfo(String ssoid, Long ts, String grp, String type, String subtype, String url, String orgid, String formid, String code, String ltpa, String sudirresponse, Date ymdh) {
        this.ssoid = ssoid;
        this.ts = ts;
        this.grp = grp;
        this.type = type;
        this.subtype = subtype;
        this.url = url;
        this.orgid = orgid;
        this.formid = formid;
        this.code = code;
        this.ltpa = ltpa;
        this.sudirresponse = sudirresponse;
        this.ymdh = ymdh;
    }

    public SessionInfo() {
    }
}
