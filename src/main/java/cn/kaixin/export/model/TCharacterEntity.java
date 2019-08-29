package cn.kaixin.export.model;

import java.sql.Timestamp;

public class TCharacterEntity {
    /** 角色ID 主键 */
    private long id;
    /** 账号ID */
    private long passportId;
    /** 角色名 */
    private String name;
    /** 玩家的头像 */
    private int photoId;
    /** 玩家的半身像 */
    private int icon;
    /** 主公模板 */
    private int masterTempId;

    /** 创建时间 */
    private Timestamp createTime;
    /** 删除日期 */
    private Timestamp deleteTime;
    /** 是否已经被删除 */
    private int isDeleted;
    /** 上次登陆IP */
    private String lastLoginIp;
    /** 上次登陆时间 */
    private Timestamp lastLoginTime;
    /** 上次登出时间 */
    private Timestamp lastLogoutTime;
    /** 累计在线时长(分钟) */
    private int totalMinute;
    /** 在线状态 */
    private int onlineStatus;
    /** 空闲时间 */
    private int idleTime;
    /** vip等级 */
    private int vipLevel;
    /** vip经验 */
    private int vipExp;
    /** 当日充值数额 */
    private int todayCharge;
    /** 总充值数额 */
    private int totalCharge;
    /** 最后充值时间 */
    private Timestamp lastChargeTime;
    /** 最后成为某级别vip的时间 */
    private Timestamp lastVipTime;

    private int quality;

    private int title;

    /**
     * 以下是玩家的基础属性
     */
    /** 等级 */
    private int level;
    /** 国家 */
    private int country;
    /** 系统赠送金币数量 */
    private int goldOfGift;
    /** 充值金币数量 */
    private int goldOfCharge;
    /** 银币数量 */
    private int silver;
    /** 银币补充数量*/
    private int silverPlus;
    /** 粮食数量 */
    private int food;
    /** 兵符数量 */
    private int token;
    /** 兵符储量 */
    private int tokenMax;
    /** 银币储量 */
    private int silverMax;
    /** 粮食储量 */
    private int foodMax;
    /** 叛军征讨令 */
    private int crusadeToken;
    /** 最大将数 */
    private int herosMax;
    /** 仓库数量上限 */
    private int inventoryMax;
    /** exp */
    private int exp;
    /** 先攻 */
    private long firstAtk;
    /** 竞技场点数 */
    private int arenaPoint;
    /** 三国无双最大副本ID */
    private int kingdomMaxRaidId;
    /** 竞技场排名 */
    private int arenaRank;
    /** 20月卡最后购买时间 */
    private long buySmallCardTime;
    /** 50月卡最后购买时间 */
    private long buyBigCardTime;
    /** 当前副本进度 */
    private int maxNormalRaidId;
    /** 名将副本 */
    private String famousRaids;

    /**
     * 以下是联合属性
     */
    /** 武将列表信息 */
    private String otherHeroPack;
    /** cd队列信息 */
    private String cdQueuePack;
    /** 其他属性信息 */
    private String otherProps;
    /** 时间奖励 */
    private String timePrizePack;

    private long guildId;
    private String guildName;
    private Timestamp nextJoinGuildTime;

    /**
     * 开放功能列表
     */
    private String openGameFunctions;

    /**
     * 上一次计算建筑产出时间
     */
    private Timestamp lastCalculateBuildingOutputTime;

    /**
     * 最大武将数量
     */
    private int maxHeroCount;

    /**
     * 角色信息
     */
    private byte[] complexInfo;

    /**
     * IOS设备Token
     */
    private String deviceToken;

    /**
     * 点券
     */
    private int coupon;

    /**
     * 点券储量
     */
    private int couponMax;

    /**
     * 记录一些是否值
     */
    private int statusMask;

    private int heroSoul;

    private String newbie;

    private String raids;

    private String currencyGain;

    private String kingdom;

    private int officeId;

    private int fame;

    private int guildContribute;

    private String activityInfo;

    private String vipInfo;

    private int vipMallStatus;
    private int vipGiftStatus;
    private int vipMallTime;

    private String allServerBonusStatus;

    private long rebelMaxDamage;

    private long rebelAccumulativeDamage;

    private int rebelDailyVersion;

    private int exploits;

    private int rebelBonusLevel;

    private int rebelLevel;

    private int kingdomStar;

    private int foundation;

    private String foundationBonus;

    private int soldierSoul;

    private int armyContribute;

    private String lastNormalRaidName;
    private String lastEliteRaidName;
    private String lastHeroRaidName;
    private int maxEliteRaidId;
    private int maxHeroRaidId;
    private int maxTianShu;
    private int maxKingdom;
    private int maxConvoyCity;
    private String netType;
    private String clientVersion;
    private String deviceModel;

    private String dailyRaid;

    private int goldSoul;

    private long lastLuxuryDinnerClaimTime;
    private long lastLuxuryDinnerChargeTime;

    private int kingdomEliteChallengeProgressId;
    private int transformId;
    private int transformLevel;

    private int starLuckyValue;

    private int groupGuyDiscount ;

    private int contendScore;
    private int crossContendMedal;
    private int contendCountry;

    private String titleInfo;
    private int brain ;
    private String richInfo;

    private int gameId ;

    private int serverId ;

    private int arenaMaxRank;

    private int redPacketSendGold;
    private int redPacketReceiveGold;
    private String redPacketAchievement;

    private String overcomeRaid;
    /** 跨服组队积分 */
    private int crossTeamScore;

    private int spiritJade;

    private int godHeroBookAdventurePoint;

    /** 神武令 */
    private int breachGold ;
    /** 联盟勋章 */
    private int guildMedal ;

    private int kingCraftSkillPoint;

    /** 战旗id */
    private int flagId;
    /** 战旗等级 */
    private int flagLevel;

    private String beastInfos;

    private int beastSoul;
    private int smithWeapon;
    private int recruitToken;

    /** 萤石 */
    private int fluorite ;
    /** 九州勋章 */
    private int zhengZhanMedal ;
    /** 魂晶 */
    private int soulCrystal;
    /** 逐鹿荣誉 */
    private int zhuLuHonor;
    /** 欢乐币 */
    private int happyBi ;
    /** 勇士之魂  */
    private int warriorSoul;
    /** 铸币 */
    private int zhuBi ;
    /**将军令 */
    private int curGeneralBi;
    /**群英传具体信息*/
    private String qunyingzhuanJson;

    /**群英传其他参数具体信息*/
    private String qunyingzhuanOtherParameterJson;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPassportId() {
        return passportId;
    }

    public void setPassportId(long passportId) {
        this.passportId = passportId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getMasterTempId() {
        return masterTempId;
    }

    public void setMasterTempId(int masterTempId) {
        this.masterTempId = masterTempId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Timestamp deleteTime) {
        this.deleteTime = deleteTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Timestamp getLastLogoutTime() {
        return lastLogoutTime;
    }

    public void setLastLogoutTime(Timestamp lastLogoutTime) {
        this.lastLogoutTime = lastLogoutTime;
    }

    public int getTotalMinute() {
        return totalMinute;
    }

    public void setTotalMinute(int totalMinute) {
        this.totalMinute = totalMinute;
    }

    public int getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(int onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public int getIdleTime() {
        return idleTime;
    }

    public void setIdleTime(int idleTime) {
        this.idleTime = idleTime;
    }

    public int getVipLevel() {
        return vipLevel;
    }

    public void setVipLevel(int vipLevel) {
        this.vipLevel = vipLevel;
    }

    public int getVipExp() {
        return vipExp;
    }

    public void setVipExp(int vipExp) {
        this.vipExp = vipExp;
    }

    public int getTodayCharge() {
        return todayCharge;
    }

    public void setTodayCharge(int todayCharge) {
        this.todayCharge = todayCharge;
    }

    public int getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(int totalCharge) {
        this.totalCharge = totalCharge;
    }

    public Timestamp getLastChargeTime() {
        return lastChargeTime;
    }

    public void setLastChargeTime(Timestamp lastChargeTime) {
        this.lastChargeTime = lastChargeTime;
    }

    public Timestamp getLastVipTime() {
        return lastVipTime;
    }

    public void setLastVipTime(Timestamp lastVipTime) {
        this.lastVipTime = lastVipTime;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getGoldOfGift() {
        return goldOfGift;
    }

    public void setGoldOfGift(int goldOfGift) {
        this.goldOfGift = goldOfGift;
    }

    public int getGoldOfCharge() {
        return goldOfCharge;
    }

    public void setGoldOfCharge(int goldOfCharge) {
        this.goldOfCharge = goldOfCharge;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getSilverPlus() {
        return silverPlus;
    }

    public void setSilverPlus(int silverPlus) {
        this.silverPlus = silverPlus;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getTokenMax() {
        return tokenMax;
    }

    public void setTokenMax(int tokenMax) {
        this.tokenMax = tokenMax;
    }

    public int getSilverMax() {
        return silverMax;
    }

    public void setSilverMax(int silverMax) {
        this.silverMax = silverMax;
    }

    public int getFoodMax() {
        return foodMax;
    }

    public void setFoodMax(int foodMax) {
        this.foodMax = foodMax;
    }

    public int getCrusadeToken() {
        return crusadeToken;
    }

    public void setCrusadeToken(int crusadeToken) {
        this.crusadeToken = crusadeToken;
    }

    public int getHerosMax() {
        return herosMax;
    }

    public void setHerosMax(int herosMax) {
        this.herosMax = herosMax;
    }

    public int getInventoryMax() {
        return inventoryMax;
    }

    public void setInventoryMax(int inventoryMax) {
        this.inventoryMax = inventoryMax;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public long getFirstAtk() {
        return firstAtk;
    }

    public void setFirstAtk(long firstAtk) {
        this.firstAtk = firstAtk;
    }

    public int getArenaPoint() {
        return arenaPoint;
    }

    public void setArenaPoint(int arenaPoint) {
        this.arenaPoint = arenaPoint;
    }

    public int getKingdomMaxRaidId() {
        return kingdomMaxRaidId;
    }

    public void setKingdomMaxRaidId(int kingdomMaxRaidId) {
        this.kingdomMaxRaidId = kingdomMaxRaidId;
    }

    public int getArenaRank() {
        return arenaRank;
    }

    public void setArenaRank(int arenaRank) {
        this.arenaRank = arenaRank;
    }

    public long getBuySmallCardTime() {
        return buySmallCardTime;
    }

    public void setBuySmallCardTime(long buySmallCardTime) {
        this.buySmallCardTime = buySmallCardTime;
    }

    public long getBuyBigCardTime() {
        return buyBigCardTime;
    }

    public void setBuyBigCardTime(long buyBigCardTime) {
        this.buyBigCardTime = buyBigCardTime;
    }

    public int getMaxNormalRaidId() {
        return maxNormalRaidId;
    }

    public void setMaxNormalRaidId(int maxNormalRaidId) {
        this.maxNormalRaidId = maxNormalRaidId;
    }

    public String getFamousRaids() {
        return famousRaids;
    }

    public void setFamousRaids(String famousRaids) {
        this.famousRaids = famousRaids;
    }

    public String getOtherHeroPack() {
        return otherHeroPack;
    }

    public void setOtherHeroPack(String otherHeroPack) {
        this.otherHeroPack = otherHeroPack;
    }

    public String getCdQueuePack() {
        return cdQueuePack;
    }

    public void setCdQueuePack(String cdQueuePack) {
        this.cdQueuePack = cdQueuePack;
    }

    public String getOtherProps() {
        return otherProps;
    }

    public void setOtherProps(String otherProps) {
        this.otherProps = otherProps;
    }

    public String getTimePrizePack() {
        return timePrizePack;
    }

    public void setTimePrizePack(String timePrizePack) {
        this.timePrizePack = timePrizePack;
    }

    public long getGuildId() {
        return guildId;
    }

    public void setGuildId(long guildId) {
        this.guildId = guildId;
    }

    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public Timestamp getNextJoinGuildTime() {
        return nextJoinGuildTime;
    }

    public void setNextJoinGuildTime(Timestamp nextJoinGuildTime) {
        this.nextJoinGuildTime = nextJoinGuildTime;
    }

    public String getOpenGameFunctions() {
        return openGameFunctions;
    }

    public void setOpenGameFunctions(String openGameFunctions) {
        this.openGameFunctions = openGameFunctions;
    }

    public Timestamp getLastCalculateBuildingOutputTime() {
        return lastCalculateBuildingOutputTime;
    }

    public void setLastCalculateBuildingOutputTime(Timestamp lastCalculateBuildingOutputTime) {
        this.lastCalculateBuildingOutputTime = lastCalculateBuildingOutputTime;
    }

    public int getMaxHeroCount() {
        return maxHeroCount;
    }

    public void setMaxHeroCount(int maxHeroCount) {
        this.maxHeroCount = maxHeroCount;
    }

    public byte[] getComplexInfo() {
        return complexInfo;
    }

    public void setComplexInfo(byte[] complexInfo) {
        this.complexInfo = complexInfo;
    }

    public String getDeviceToken() {
        return deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    public int getCoupon() {
        return coupon;
    }

    public void setCoupon(int coupon) {
        this.coupon = coupon;
    }

    public int getCouponMax() {
        return couponMax;
    }

    public void setCouponMax(int couponMax) {
        this.couponMax = couponMax;
    }

    public int getStatusMask() {
        return statusMask;
    }

    public void setStatusMask(int statusMask) {
        this.statusMask = statusMask;
    }

    public int getHeroSoul() {
        return heroSoul;
    }

    public void setHeroSoul(int heroSoul) {
        this.heroSoul = heroSoul;
    }

    public String getNewbie() {
        return newbie;
    }

    public void setNewbie(String newbie) {
        this.newbie = newbie;
    }

    public String getRaids() {
        return raids;
    }

    public void setRaids(String raids) {
        this.raids = raids;
    }

    public String getCurrencyGain() {
        return currencyGain;
    }

    public void setCurrencyGain(String currencyGain) {
        this.currencyGain = currencyGain;
    }

    public String getKingdom() {
        return kingdom;
    }

    public void setKingdom(String kingdom) {
        this.kingdom = kingdom;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }

    public int getFame() {
        return fame;
    }

    public void setFame(int fame) {
        this.fame = fame;
    }

    public int getGuildContribute() {
        return guildContribute;
    }

    public void setGuildContribute(int guildContribute) {
        this.guildContribute = guildContribute;
    }

    public String getActivityInfo() {
        return activityInfo;
    }

    public void setActivityInfo(String activityInfo) {
        this.activityInfo = activityInfo;
    }

    public String getVipInfo() {
        return vipInfo;
    }

    public void setVipInfo(String vipInfo) {
        this.vipInfo = vipInfo;
    }

    public int getVipMallStatus() {
        return vipMallStatus;
    }

    public void setVipMallStatus(int vipMallStatus) {
        this.vipMallStatus = vipMallStatus;
    }

    public int getVipGiftStatus() {
        return vipGiftStatus;
    }

    public void setVipGiftStatus(int vipGiftStatus) {
        this.vipGiftStatus = vipGiftStatus;
    }

    public int getVipMallTime() {
        return vipMallTime;
    }

    public void setVipMallTime(int vipMallTime) {
        this.vipMallTime = vipMallTime;
    }

    public String getAllServerBonusStatus() {
        return allServerBonusStatus;
    }

    public void setAllServerBonusStatus(String allServerBonusStatus) {
        this.allServerBonusStatus = allServerBonusStatus;
    }

    public long getRebelMaxDamage() {
        return rebelMaxDamage;
    }

    public void setRebelMaxDamage(long rebelMaxDamage) {
        this.rebelMaxDamage = rebelMaxDamage;
    }

    public long getRebelAccumulativeDamage() {
        return rebelAccumulativeDamage;
    }

    public void setRebelAccumulativeDamage(long rebelAccumulativeDamage) {
        this.rebelAccumulativeDamage = rebelAccumulativeDamage;
    }

    public int getRebelDailyVersion() {
        return rebelDailyVersion;
    }

    public void setRebelDailyVersion(int rebelDailyVersion) {
        this.rebelDailyVersion = rebelDailyVersion;
    }

    public int getExploits() {
        return exploits;
    }

    public void setExploits(int exploits) {
        this.exploits = exploits;
    }

    public int getRebelBonusLevel() {
        return rebelBonusLevel;
    }

    public void setRebelBonusLevel(int rebelBonusLevel) {
        this.rebelBonusLevel = rebelBonusLevel;
    }

    public int getRebelLevel() {
        return rebelLevel;
    }

    public void setRebelLevel(int rebelLevel) {
        this.rebelLevel = rebelLevel;
    }

    public int getKingdomStar() {
        return kingdomStar;
    }

    public void setKingdomStar(int kingdomStar) {
        this.kingdomStar = kingdomStar;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }

    public String getFoundationBonus() {
        return foundationBonus;
    }

    public void setFoundationBonus(String foundationBonus) {
        this.foundationBonus = foundationBonus;
    }

    public int getSoldierSoul() {
        return soldierSoul;
    }

    public void setSoldierSoul(int soldierSoul) {
        this.soldierSoul = soldierSoul;
    }

    public int getArmyContribute() {
        return armyContribute;
    }

    public void setArmyContribute(int armyContribute) {
        this.armyContribute = armyContribute;
    }

    public String getLastNormalRaidName() {
        return lastNormalRaidName;
    }

    public void setLastNormalRaidName(String lastNormalRaidName) {
        this.lastNormalRaidName = lastNormalRaidName;
    }

    public String getLastEliteRaidName() {
        return lastEliteRaidName;
    }

    public void setLastEliteRaidName(String lastEliteRaidName) {
        this.lastEliteRaidName = lastEliteRaidName;
    }

    public String getLastHeroRaidName() {
        return lastHeroRaidName;
    }

    public void setLastHeroRaidName(String lastHeroRaidName) {
        this.lastHeroRaidName = lastHeroRaidName;
    }

    public int getMaxEliteRaidId() {
        return maxEliteRaidId;
    }

    public void setMaxEliteRaidId(int maxEliteRaidId) {
        this.maxEliteRaidId = maxEliteRaidId;
    }

    public int getMaxHeroRaidId() {
        return maxHeroRaidId;
    }

    public void setMaxHeroRaidId(int maxHeroRaidId) {
        this.maxHeroRaidId = maxHeroRaidId;
    }

    public int getMaxTianShu() {
        return maxTianShu;
    }

    public void setMaxTianShu(int maxTianShu) {
        this.maxTianShu = maxTianShu;
    }

    public int getMaxKingdom() {
        return maxKingdom;
    }

    public void setMaxKingdom(int maxKingdom) {
        this.maxKingdom = maxKingdom;
    }

    public int getMaxConvoyCity() {
        return maxConvoyCity;
    }

    public void setMaxConvoyCity(int maxConvoyCity) {
        this.maxConvoyCity = maxConvoyCity;
    }

    public String getNetType() {
        return netType;
    }

    public void setNetType(String netType) {
        this.netType = netType;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getDailyRaid() {
        return dailyRaid;
    }

    public void setDailyRaid(String dailyRaid) {
        this.dailyRaid = dailyRaid;
    }

    public int getGoldSoul() {
        return goldSoul;
    }

    public void setGoldSoul(int goldSoul) {
        this.goldSoul = goldSoul;
    }

    public long getLastLuxuryDinnerClaimTime() {
        return lastLuxuryDinnerClaimTime;
    }

    public void setLastLuxuryDinnerClaimTime(long lastLuxuryDinnerClaimTime) {
        this.lastLuxuryDinnerClaimTime = lastLuxuryDinnerClaimTime;
    }

    public long getLastLuxuryDinnerChargeTime() {
        return lastLuxuryDinnerChargeTime;
    }

    public void setLastLuxuryDinnerChargeTime(long lastLuxuryDinnerChargeTime) {
        this.lastLuxuryDinnerChargeTime = lastLuxuryDinnerChargeTime;
    }

    public int getKingdomEliteChallengeProgressId() {
        return kingdomEliteChallengeProgressId;
    }

    public void setKingdomEliteChallengeProgressId(int kingdomEliteChallengeProgressId) {
        this.kingdomEliteChallengeProgressId = kingdomEliteChallengeProgressId;
    }

    public int getTransformId() {
        return transformId;
    }

    public void setTransformId(int transformId) {
        this.transformId = transformId;
    }

    public int getTransformLevel() {
        return transformLevel;
    }

    public void setTransformLevel(int transformLevel) {
        this.transformLevel = transformLevel;
    }

    public int getStarLuckyValue() {
        return starLuckyValue;
    }

    public void setStarLuckyValue(int starLuckyValue) {
        this.starLuckyValue = starLuckyValue;
    }

    public int getGroupGuyDiscount() {
        return groupGuyDiscount;
    }

    public void setGroupGuyDiscount(int groupGuyDiscount) {
        this.groupGuyDiscount = groupGuyDiscount;
    }

    public int getContendScore() {
        return contendScore;
    }

    public void setContendScore(int contendScore) {
        this.contendScore = contendScore;
    }

    public int getCrossContendMedal() {
        return crossContendMedal;
    }

    public void setCrossContendMedal(int crossContendMedal) {
        this.crossContendMedal = crossContendMedal;
    }

    public int getContendCountry() {
        return contendCountry;
    }

    public void setContendCountry(int contendCountry) {
        this.contendCountry = contendCountry;
    }

    public String getTitleInfo() {
        return titleInfo;
    }

    public void setTitleInfo(String titleInfo) {
        this.titleInfo = titleInfo;
    }

    public int getBrain() {
        return brain;
    }

    public void setBrain(int brain) {
        this.brain = brain;
    }

    public String getRichInfo() {
        return richInfo;
    }

    public void setRichInfo(String richInfo) {
        this.richInfo = richInfo;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    public int getArenaMaxRank() {
        return arenaMaxRank;
    }

    public void setArenaMaxRank(int arenaMaxRank) {
        this.arenaMaxRank = arenaMaxRank;
    }

    public int getRedPacketSendGold() {
        return redPacketSendGold;
    }

    public void setRedPacketSendGold(int redPacketSendGold) {
        this.redPacketSendGold = redPacketSendGold;
    }

    public int getRedPacketReceiveGold() {
        return redPacketReceiveGold;
    }

    public void setRedPacketReceiveGold(int redPacketReceiveGold) {
        this.redPacketReceiveGold = redPacketReceiveGold;
    }

    public String getRedPacketAchievement() {
        return redPacketAchievement;
    }

    public void setRedPacketAchievement(String redPacketAchievement) {
        this.redPacketAchievement = redPacketAchievement;
    }

    public String getOvercomeRaid() {
        return overcomeRaid;
    }

    public void setOvercomeRaid(String overcomeRaid) {
        this.overcomeRaid = overcomeRaid;
    }

    public int getCrossTeamScore() {
        return crossTeamScore;
    }

    public void setCrossTeamScore(int crossTeamScore) {
        this.crossTeamScore = crossTeamScore;
    }

    public int getSpiritJade() {
        return spiritJade;
    }

    public void setSpiritJade(int spiritJade) {
        this.spiritJade = spiritJade;
    }

    public int getGodHeroBookAdventurePoint() {
        return godHeroBookAdventurePoint;
    }

    public void setGodHeroBookAdventurePoint(int godHeroBookAdventurePoint) {
        this.godHeroBookAdventurePoint = godHeroBookAdventurePoint;
    }

    public int getBreachGold() {
        return breachGold;
    }

    public void setBreachGold(int breachGold) {
        this.breachGold = breachGold;
    }

    public int getGuildMedal() {
        return guildMedal;
    }

    public void setGuildMedal(int guildMedal) {
        this.guildMedal = guildMedal;
    }

    public int getKingCraftSkillPoint() {
        return kingCraftSkillPoint;
    }

    public void setKingCraftSkillPoint(int kingCraftSkillPoint) {
        this.kingCraftSkillPoint = kingCraftSkillPoint;
    }

    public int getFlagId() {
        return flagId;
    }

    public void setFlagId(int flagId) {
        this.flagId = flagId;
    }

    public int getFlagLevel() {
        return flagLevel;
    }

    public void setFlagLevel(int flagLevel) {
        this.flagLevel = flagLevel;
    }

    public String getBeastInfos() {
        return beastInfos;
    }

    public void setBeastInfos(String beastInfos) {
        this.beastInfos = beastInfos;
    }

    public int getBeastSoul() {
        return beastSoul;
    }

    public void setBeastSoul(int beastSoul) {
        this.beastSoul = beastSoul;
    }

    public int getSmithWeapon() {
        return smithWeapon;
    }

    public void setSmithWeapon(int smithWeapon) {
        this.smithWeapon = smithWeapon;
    }

    public int getRecruitToken() {
        return recruitToken;
    }

    public void setRecruitToken(int recruitToken) {
        this.recruitToken = recruitToken;
    }

    public int getFluorite() {
        return fluorite;
    }

    public void setFluorite(int fluorite) {
        this.fluorite = fluorite;
    }

    public int getZhengZhanMedal() {
        return zhengZhanMedal;
    }

    public void setZhengZhanMedal(int zhengZhanMedal) {
        this.zhengZhanMedal = zhengZhanMedal;
    }

    public int getSoulCrystal() {
        return soulCrystal;
    }

    public void setSoulCrystal(int soulCrystal) {
        this.soulCrystal = soulCrystal;
    }

    public int getZhuLuHonor() {
        return zhuLuHonor;
    }

    public void setZhuLuHonor(int zhuLuHonor) {
        this.zhuLuHonor = zhuLuHonor;
    }

    public int getHappyBi() {
        return happyBi;
    }

    public void setHappyBi(int happyBi) {
        this.happyBi = happyBi;
    }

    public int getWarriorSoul() {
        return warriorSoul;
    }

    public void setWarriorSoul(int warriorSoul) {
        this.warriorSoul = warriorSoul;
    }

    public int getZhuBi() {
        return zhuBi;
    }

    public void setZhuBi(int zhuBi) {
        this.zhuBi = zhuBi;
    }

    public int getCurGeneralBi() {
        return curGeneralBi;
    }

    public void setCurGeneralBi(int curGeneralBi) {
        this.curGeneralBi = curGeneralBi;
    }

    public String getQunyingzhuanJson() {
        return qunyingzhuanJson;
    }

    public void setQunyingzhuanJson(String qunyingzhuanJson) {
        this.qunyingzhuanJson = qunyingzhuanJson;
    }

    public String getQunyingzhuanOtherParameterJson() {
        return qunyingzhuanOtherParameterJson;
    }

    public void setQunyingzhuanOtherParameterJson(String qunyingzhuanOtherParameterJson) {
        this.qunyingzhuanOtherParameterJson = qunyingzhuanOtherParameterJson;
    }
}