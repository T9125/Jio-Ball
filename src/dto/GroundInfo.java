package dto;

import java.sql.Timestamp;

public class GroundInfo {
	private int groundNo;
	private String groundName;
	private String groundLocation;
	private String groundSize;
	private Timestamp groundOpenTime;
	private Timestamp groundCloseTime;
	private int groundShower;
	private int groundParking;
	private int groundShoes;
	private int groundBib;
	private String groundNotice;
	private int groundFee;
	private int playTypeNo;
	private int playLocalNo;
	private String groundImgName;
	private String groundImgPath;
	
	@Override
	public String toString() {
		return "GroundInfo [groundNo=" + groundNo + ", groundName=" + groundName + ", groundLocation=" + groundLocation
				+ ", groundSize=" + groundSize + ", groundOpenTime=" + groundOpenTime + ", groundCloseTime="
				+ groundCloseTime + ", groundShower=" + groundShower + ", groundParking=" + groundParking
				+ ", groundShoes=" + groundShoes + ", groundBib=" + groundBib + ", groundNotice=" + groundNotice
				+ ", groundFee=" + groundFee + ", playTypeNo=" + playTypeNo + ", playLocalNo=" + playLocalNo
				+ ", groundImgName=" + groundImgName + ", groundImgPath=" + groundImgPath + "]";
	}
	public int getGroundNo() {
		return groundNo;
	}
	public void setGroundNo(int groundNo) {
		this.groundNo = groundNo;
	}
	public String getGroundName() {
		return groundName;
	}
	public void setGroundName(String groundName) {
		this.groundName = groundName;
	}
	public String getGroundLocation() {
		return groundLocation;
	}
	public void setGroundLocation(String groundLocation) {
		this.groundLocation = groundLocation;
	}
	public String getGroundSize() {
		return groundSize;
	}
	public void setGroundSize(String groundSize) {
		this.groundSize = groundSize;
	}
	public Timestamp getGroundOpenTime() {
		return groundOpenTime;
	}
	public void setGroundOpenTime(Timestamp groundOpenTime) {
		this.groundOpenTime = groundOpenTime;
	}
	public Timestamp getGroundCloseTime() {
		return groundCloseTime;
	}
	public void setGroundCloseTime(Timestamp groundCloseTime) {
		this.groundCloseTime = groundCloseTime;
	}
	public int getGroundShower() {
		return groundShower;
	}
	public void setGroundShower(int groundShower) {
		this.groundShower = groundShower;
	}
	public int getGroundParking() {
		return groundParking;
	}
	public void setGroundParking(int groundParking) {
		this.groundParking = groundParking;
	}
	public int getGroundShoes() {
		return groundShoes;
	}
	public void setGroundShoes(int groundShoes) {
		this.groundShoes = groundShoes;
	}
	public int getGroundBib() {
		return groundBib;
	}
	public void setGroundBib(int groundBib) {
		this.groundBib = groundBib;
	}
	public String getGroundNotice() {
		return groundNotice;
	}
	public void setGroundNotice(String groundNotice) {
		this.groundNotice = groundNotice;
	}
	public int getGroundFee() {
		return groundFee;
	}
	public void setGroundFee(int groundFee) {
		this.groundFee = groundFee;
	}
	public int getPlayTypeNo() {
		return playTypeNo;
	}
	public void setPlayTypeNo(int playTypeNo) {
		this.playTypeNo = playTypeNo;
	}
	public int getPlayLocalNo() {
		return playLocalNo;
	}
	public void setPlayLocalNo(int playLocalNo) {
		this.playLocalNo = playLocalNo;
	}
	public String getGroundImgName() {
		return groundImgName;
	}
	public void setGroundImgName(String groundImgName) {
		this.groundImgName = groundImgName;
	}
	public String getGroundImgPath() {
		return groundImgPath;
	}
	public void setGroundImgPath(String groundImgPath) {
		this.groundImgPath = groundImgPath;
	}
}