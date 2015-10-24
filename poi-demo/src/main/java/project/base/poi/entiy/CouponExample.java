package project.base.poi.entiy;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias(value = "couponExample")
public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value,
                String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property
                        + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1,
                Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property
                        + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("\"id\" is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("\"id\" is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("\"id\" =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("\"id\" <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("\"id\" >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("\"id\" >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("\"id\" <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("\"id\" <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("\"id\" in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("\"id\" not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("\"id\" between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("\"id\" not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCodeIsNull() {
            addCriterion("\"code\" is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("\"code\" is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("\"code\" =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("\"code\" <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("\"code\" >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("\"code\" >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("\"code\" <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("\"code\" <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("\"code\" like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("\"code\" not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("\"code\" in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("\"code\" not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("\"code\" between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("\"code\" not between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("\"name\" is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("\"name\" is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("\"name\" =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("\"name\" <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("\"name\" >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("\"name\" >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("\"name\" <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("\"name\" <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("\"name\" like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("\"name\" not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("\"name\" in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("\"name\" not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("\"name\" between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("\"name\" not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmIsNull() {
            addCriterion("\"fitToMinKm\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmIsNotNull() {
            addCriterion("\"fitToMinKm\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmEqualTo(Integer value) {
            addCriterion("\"fitToMinKm\" =", value, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmNotEqualTo(Integer value) {
            addCriterion("\"fitToMinKm\" <>", value, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmGreaterThan(Integer value) {
            addCriterion("\"fitToMinKm\" >", value, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMinKm\" >=", value, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmLessThan(Integer value) {
            addCriterion("\"fitToMinKm\" <", value, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmLessThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMinKm\" <=", value, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmIn(List<Integer> values) {
            addCriterion("\"fitToMinKm\" in", values, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmNotIn(List<Integer> values) {
            addCriterion("\"fitToMinKm\" not in", values, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmBetween(Integer value1, Integer value2) {
            addCriterion("\"fitToMinKm\" between", value1, value2, "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinKmNotBetween(Integer value1, Integer value2) {
            addCriterion("\"fitToMinKm\" not between", value1, value2,
                    "fitToMinKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmIsNull() {
            addCriterion("\"fitToMaxKm\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmIsNotNull() {
            addCriterion("\"fitToMaxKm\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmEqualTo(Integer value) {
            addCriterion("\"fitToMaxKm\" =", value, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmNotEqualTo(Integer value) {
            addCriterion("\"fitToMaxKm\" <>", value, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmGreaterThan(Integer value) {
            addCriterion("\"fitToMaxKm\" >", value, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMaxKm\" >=", value, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmLessThan(Integer value) {
            addCriterion("\"fitToMaxKm\" <", value, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmLessThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMaxKm\" <=", value, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmIn(List<Integer> values) {
            addCriterion("\"fitToMaxKm\" in", values, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmNotIn(List<Integer> values) {
            addCriterion("\"fitToMaxKm\" not in", values, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmBetween(Integer value1, Integer value2) {
            addCriterion("\"fitToMaxKm\" between", value1, value2, "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMaxKmNotBetween(Integer value1, Integer value2) {
            addCriterion("\"fitToMaxKm\" not between", value1, value2,
                    "fitToMaxKm");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedIsNull() {
            addCriterion("\"fitToMinDaysUsed\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedIsNotNull() {
            addCriterion("\"fitToMinDaysUsed\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedEqualTo(Integer value) {
            addCriterion("\"fitToMinDaysUsed\" =", value, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedNotEqualTo(Integer value) {
            addCriterion("\"fitToMinDaysUsed\" <>", value, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedGreaterThan(Integer value) {
            addCriterion("\"fitToMinDaysUsed\" >", value, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMinDaysUsed\" >=", value, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedLessThan(Integer value) {
            addCriterion("\"fitToMinDaysUsed\" <", value, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedLessThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMinDaysUsed\" <=", value, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedIn(List<Integer> values) {
            addCriterion("\"fitToMinDaysUsed\" in", values, "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedNotIn(List<Integer> values) {
            addCriterion("\"fitToMinDaysUsed\" not in", values,
                    "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedBetween(Integer value1,
                Integer value2) {
            addCriterion("\"fitToMinDaysUsed\" between", value1, value2,
                    "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMinDaysUsedNotBetween(Integer value1,
                Integer value2) {
            addCriterion("\"fitToMinDaysUsed\" not between", value1, value2,
                    "fitToMinDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedIsNull() {
            addCriterion("\"fitToMaxDaysUsed\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedIsNotNull() {
            addCriterion("\"fitToMaxDaysUsed\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedEqualTo(Integer value) {
            addCriterion("\"fitToMaxDaysUsed\" =", value, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedNotEqualTo(Integer value) {
            addCriterion("\"fitToMaxDaysUsed\" <>", value, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedGreaterThan(Integer value) {
            addCriterion("\"fitToMaxDaysUsed\" >", value, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMaxDaysUsed\" >=", value, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedLessThan(Integer value) {
            addCriterion("\"fitToMaxDaysUsed\" <", value, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedLessThanOrEqualTo(Integer value) {
            addCriterion("\"fitToMaxDaysUsed\" <=", value, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedIn(List<Integer> values) {
            addCriterion("\"fitToMaxDaysUsed\" in", values, "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedNotIn(List<Integer> values) {
            addCriterion("\"fitToMaxDaysUsed\" not in", values,
                    "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedBetween(Integer value1,
                Integer value2) {
            addCriterion("\"fitToMaxDaysUsed\" between", value1, value2,
                    "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToMaxDaysUsedNotBetween(Integer value1,
                Integer value2) {
            addCriterion("\"fitToMaxDaysUsed\" not between", value1, value2,
                    "fitToMaxDaysUsed");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeIsNull() {
            addCriterion("\"fitToEmissionVolume\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeIsNotNull() {
            addCriterion("\"fitToEmissionVolume\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeEqualTo(String value) {
            addCriterion("\"fitToEmissionVolume\" =", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeNotEqualTo(String value) {
            addCriterion("\"fitToEmissionVolume\" <>", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeGreaterThan(String value) {
            addCriterion("\"fitToEmissionVolume\" >", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeGreaterThanOrEqualTo(String value) {
            addCriterion("\"fitToEmissionVolume\" >=", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeLessThan(String value) {
            addCriterion("\"fitToEmissionVolume\" <", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeLessThanOrEqualTo(String value) {
            addCriterion("\"fitToEmissionVolume\" <=", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeLike(String value) {
            addCriterion("\"fitToEmissionVolume\" like", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeNotLike(String value) {
            addCriterion("\"fitToEmissionVolume\" not like", value,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeIn(List<String> values) {
            addCriterion("\"fitToEmissionVolume\" in", values,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeNotIn(List<String> values) {
            addCriterion("\"fitToEmissionVolume\" not in", values,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeBetween(String value1,
                String value2) {
            addCriterion("\"fitToEmissionVolume\" between", value1, value2,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToEmissionVolumeNotBetween(String value1,
                String value2) {
            addCriterion("\"fitToEmissionVolume\" not between", value1, value2,
                    "fitToEmissionVolume");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeIsNull() {
            addCriterion("\"fitToVehicleScope\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeIsNotNull() {
            addCriterion("\"fitToVehicleScope\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeEqualTo(String value) {
            addCriterion("\"fitToVehicleScope\" =", value, "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeNotEqualTo(String value) {
            addCriterion("\"fitToVehicleScope\" <>", value, "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeGreaterThan(String value) {
            addCriterion("\"fitToVehicleScope\" >", value, "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeGreaterThanOrEqualTo(String value) {
            addCriterion("\"fitToVehicleScope\" >=", value, "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeLessThan(String value) {
            addCriterion("\"fitToVehicleScope\" <", value, "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeLessThanOrEqualTo(String value) {
            addCriterion("\"fitToVehicleScope\" <=", value, "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeLike(String value) {
            addCriterion("\"fitToVehicleScope\" like", value,
                    "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeNotLike(String value) {
            addCriterion("\"fitToVehicleScope\" not like", value,
                    "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeIn(List<String> values) {
            addCriterion("\"fitToVehicleScope\" in", values,
                    "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeNotIn(List<String> values) {
            addCriterion("\"fitToVehicleScope\" not in", values,
                    "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeBetween(String value1, String value2) {
            addCriterion("\"fitToVehicleScope\" between", value1, value2,
                    "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToVehicleScopeNotBetween(String value1,
                String value2) {
            addCriterion("\"fitToVehicleScope\" not between", value1, value2,
                    "fitToVehicleScope");
            return (Criteria) this;
        }

        public Criteria andFitToCityIsNull() {
            addCriterion("\"fitToCity\" is null");
            return (Criteria) this;
        }

        public Criteria andFitToCityIsNotNull() {
            addCriterion("\"fitToCity\" is not null");
            return (Criteria) this;
        }

        public Criteria andFitToCityEqualTo(String value) {
            addCriterion("\"fitToCity\" =", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityNotEqualTo(String value) {
            addCriterion("\"fitToCity\" <>", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityGreaterThan(String value) {
            addCriterion("\"fitToCity\" >", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityGreaterThanOrEqualTo(String value) {
            addCriterion("\"fitToCity\" >=", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityLessThan(String value) {
            addCriterion("\"fitToCity\" <", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityLessThanOrEqualTo(String value) {
            addCriterion("\"fitToCity\" <=", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityLike(String value) {
            addCriterion("\"fitToCity\" like", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityNotLike(String value) {
            addCriterion("\"fitToCity\" not like", value, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityIn(List<String> values) {
            addCriterion("\"fitToCity\" in", values, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityNotIn(List<String> values) {
            addCriterion("\"fitToCity\" not in", values, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityBetween(String value1, String value2) {
            addCriterion("\"fitToCity\" between", value1, value2, "fitToCity");
            return (Criteria) this;
        }

        public Criteria andFitToCityNotBetween(String value1, String value2) {
            addCriterion("\"fitToCity\" not between", value1, value2,
                    "fitToCity");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeIsNull() {
            addCriterion("\"beginDatetime\" is null");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeIsNotNull() {
            addCriterion("\"beginDatetime\" is not null");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeEqualTo(Timestamp value) {
            addCriterion("\"beginDatetime\" =", value, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeNotEqualTo(Timestamp value) {
            addCriterion("\"beginDatetime\" <>", value, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeGreaterThan(Timestamp value) {
            addCriterion("\"beginDatetime\" >", value, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("\"beginDatetime\" >=", value, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeLessThan(Timestamp value) {
            addCriterion("\"beginDatetime\" <", value, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("\"beginDatetime\" <=", value, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeIn(List<Timestamp> values) {
            addCriterion("\"beginDatetime\" in", values, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeNotIn(List<Timestamp> values) {
            addCriterion("\"beginDatetime\" not in", values, "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"beginDatetime\" between", value1, value2,
                    "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andBeginDatetimeNotBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"beginDatetime\" not between", value1, value2,
                    "beginDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIsNull() {
            addCriterion("\"endDatetime\" is null");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIsNotNull() {
            addCriterion("\"endDatetime\" is not null");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeEqualTo(Timestamp value) {
            addCriterion("\"endDatetime\" =", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotEqualTo(Timestamp value) {
            addCriterion("\"endDatetime\" <>", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeGreaterThan(Timestamp value) {
            addCriterion("\"endDatetime\" >", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("\"endDatetime\" >=", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeLessThan(Timestamp value) {
            addCriterion("\"endDatetime\" <", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("\"endDatetime\" <=", value, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeIn(List<Timestamp> values) {
            addCriterion("\"endDatetime\" in", values, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotIn(List<Timestamp> values) {
            addCriterion("\"endDatetime\" not in", values, "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeBetween(Timestamp value1, Timestamp value2) {
            addCriterion("\"endDatetime\" between", value1, value2,
                    "endDatetime");
            return (Criteria) this;
        }

        public Criteria andEndDatetimeNotBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"endDatetime\" not between", value1, value2,
                    "endDatetime");
            return (Criteria) this;
        }

        public Criteria andValidInDaysIsNull() {
            addCriterion("\"validInDays\" is null");
            return (Criteria) this;
        }

        public Criteria andValidInDaysIsNotNull() {
            addCriterion("\"validInDays\" is not null");
            return (Criteria) this;
        }

        public Criteria andValidInDaysEqualTo(Integer value) {
            addCriterion("\"validInDays\" =", value, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysNotEqualTo(Integer value) {
            addCriterion("\"validInDays\" <>", value, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysGreaterThan(Integer value) {
            addCriterion("\"validInDays\" >", value, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysGreaterThanOrEqualTo(Integer value) {
            addCriterion("\"validInDays\" >=", value, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysLessThan(Integer value) {
            addCriterion("\"validInDays\" <", value, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysLessThanOrEqualTo(Integer value) {
            addCriterion("\"validInDays\" <=", value, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysIn(List<Integer> values) {
            addCriterion("\"validInDays\" in", values, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysNotIn(List<Integer> values) {
            addCriterion("\"validInDays\" not in", values, "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysBetween(Integer value1, Integer value2) {
            addCriterion("\"validInDays\" between", value1, value2,
                    "validInDays");
            return (Criteria) this;
        }

        public Criteria andValidInDaysNotBetween(Integer value1, Integer value2) {
            addCriterion("\"validInDays\" not between", value1, value2,
                    "validInDays");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIsNull() {
            addCriterion("\"moneyAmount\" is null");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIsNotNull() {
            addCriterion("\"moneyAmount\" is not null");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountEqualTo(Float value) {
            addCriterion("\"moneyAmount\" =", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotEqualTo(Float value) {
            addCriterion("\"moneyAmount\" <>", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountGreaterThan(Float value) {
            addCriterion("\"moneyAmount\" >", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountGreaterThanOrEqualTo(Float value) {
            addCriterion("\"moneyAmount\" >=", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountLessThan(Float value) {
            addCriterion("\"moneyAmount\" <", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountLessThanOrEqualTo(Float value) {
            addCriterion("\"moneyAmount\" <=", value, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountIn(List<Float> values) {
            addCriterion("\"moneyAmount\" in", values, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotIn(List<Float> values) {
            addCriterion("\"moneyAmount\" not in", values, "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountBetween(Float value1, Float value2) {
            addCriterion("\"moneyAmount\" between", value1, value2,
                    "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andMoneyAmountNotBetween(Float value1, Float value2) {
            addCriterion("\"moneyAmount\" not between", value1, value2,
                    "moneyAmount");
            return (Criteria) this;
        }

        public Criteria andColor1IsNull() {
            addCriterion("\"color1\" is null");
            return (Criteria) this;
        }

        public Criteria andColor1IsNotNull() {
            addCriterion("\"color1\" is not null");
            return (Criteria) this;
        }

        public Criteria andColor1EqualTo(String value) {
            addCriterion("\"color1\" =", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1NotEqualTo(String value) {
            addCriterion("\"color1\" <>", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1GreaterThan(String value) {
            addCriterion("\"color1\" >", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1GreaterThanOrEqualTo(String value) {
            addCriterion("\"color1\" >=", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1LessThan(String value) {
            addCriterion("\"color1\" <", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1LessThanOrEqualTo(String value) {
            addCriterion("\"color1\" <=", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1Like(String value) {
            addCriterion("\"color1\" like", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1NotLike(String value) {
            addCriterion("\"color1\" not like", value, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1In(List<String> values) {
            addCriterion("\"color1\" in", values, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1NotIn(List<String> values) {
            addCriterion("\"color1\" not in", values, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1Between(String value1, String value2) {
            addCriterion("\"color1\" between", value1, value2, "color1");
            return (Criteria) this;
        }

        public Criteria andColor1NotBetween(String value1, String value2) {
            addCriterion("\"color1\" not between", value1, value2, "color1");
            return (Criteria) this;
        }

        public Criteria andColor2IsNull() {
            addCriterion("\"color2\" is null");
            return (Criteria) this;
        }

        public Criteria andColor2IsNotNull() {
            addCriterion("\"color2\" is not null");
            return (Criteria) this;
        }

        public Criteria andColor2EqualTo(String value) {
            addCriterion("\"color2\" =", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2NotEqualTo(String value) {
            addCriterion("\"color2\" <>", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2GreaterThan(String value) {
            addCriterion("\"color2\" >", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2GreaterThanOrEqualTo(String value) {
            addCriterion("\"color2\" >=", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2LessThan(String value) {
            addCriterion("\"color2\" <", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2LessThanOrEqualTo(String value) {
            addCriterion("\"color2\" <=", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2Like(String value) {
            addCriterion("\"color2\" like", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2NotLike(String value) {
            addCriterion("\"color2\" not like", value, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2In(List<String> values) {
            addCriterion("\"color2\" in", values, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2NotIn(List<String> values) {
            addCriterion("\"color2\" not in", values, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2Between(String value1, String value2) {
            addCriterion("\"color2\" between", value1, value2, "color2");
            return (Criteria) this;
        }

        public Criteria andColor2NotBetween(String value1, String value2) {
            addCriterion("\"color2\" not between", value1, value2, "color2");
            return (Criteria) this;
        }

        public Criteria andRuleBriefIsNull() {
            addCriterion("\"ruleBrief\" is null");
            return (Criteria) this;
        }

        public Criteria andRuleBriefIsNotNull() {
            addCriterion("\"ruleBrief\" is not null");
            return (Criteria) this;
        }

        public Criteria andRuleBriefEqualTo(String value) {
            addCriterion("\"ruleBrief\" =", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefNotEqualTo(String value) {
            addCriterion("\"ruleBrief\" <>", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefGreaterThan(String value) {
            addCriterion("\"ruleBrief\" >", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefGreaterThanOrEqualTo(String value) {
            addCriterion("\"ruleBrief\" >=", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefLessThan(String value) {
            addCriterion("\"ruleBrief\" <", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefLessThanOrEqualTo(String value) {
            addCriterion("\"ruleBrief\" <=", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefLike(String value) {
            addCriterion("\"ruleBrief\" like", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefNotLike(String value) {
            addCriterion("\"ruleBrief\" not like", value, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefIn(List<String> values) {
            addCriterion("\"ruleBrief\" in", values, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefNotIn(List<String> values) {
            addCriterion("\"ruleBrief\" not in", values, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefBetween(String value1, String value2) {
            addCriterion("\"ruleBrief\" between", value1, value2, "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andRuleBriefNotBetween(String value1, String value2) {
            addCriterion("\"ruleBrief\" not between", value1, value2,
                    "ruleBrief");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("\"description\" is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("\"description\" is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("\"description\" =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("\"description\" <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("\"description\" >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("\"description\" >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("\"description\" <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("\"description\" <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("\"description\" like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("\"description\" not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("\"description\" in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("\"description\" not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("\"description\" between", value1, value2,
                    "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("\"description\" not between", value1, value2,
                    "description");
            return (Criteria) this;
        }

        public Criteria andActivedIsNull() {
            addCriterion("\"actived\" is null");
            return (Criteria) this;
        }

        public Criteria andActivedIsNotNull() {
            addCriterion("\"actived\" is not null");
            return (Criteria) this;
        }

        public Criteria andActivedEqualTo(Boolean value) {
            addCriterion("\"actived\" =", value, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedNotEqualTo(Boolean value) {
            addCriterion("\"actived\" <>", value, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedGreaterThan(Boolean value) {
            addCriterion("\"actived\" >", value, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("\"actived\" >=", value, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedLessThan(Boolean value) {
            addCriterion("\"actived\" <", value, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedLessThanOrEqualTo(Boolean value) {
            addCriterion("\"actived\" <=", value, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedIn(List<Boolean> values) {
            addCriterion("\"actived\" in", values, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedNotIn(List<Boolean> values) {
            addCriterion("\"actived\" not in", values, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedBetween(Boolean value1, Boolean value2) {
            addCriterion("\"actived\" between", value1, value2, "actived");
            return (Criteria) this;
        }

        public Criteria andActivedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("\"actived\" not between", value1, value2, "actived");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("\"deleted\" is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("\"deleted\" is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("\"deleted\" =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("\"deleted\" <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("\"deleted\" >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("\"deleted\" >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("\"deleted\" <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("\"deleted\" <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("\"deleted\" in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("\"deleted\" not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("\"deleted\" between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("\"deleted\" not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIsNull() {
            addCriterion("\"createdDatetime\" is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIsNotNull() {
            addCriterion("\"createdDatetime\" is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeEqualTo(Timestamp value) {
            addCriterion("\"createdDatetime\" =", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotEqualTo(Timestamp value) {
            addCriterion("\"createdDatetime\" <>", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeGreaterThan(Timestamp value) {
            addCriterion("\"createdDatetime\" >", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("\"createdDatetime\" >=", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLessThan(Timestamp value) {
            addCriterion("\"createdDatetime\" <", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("\"createdDatetime\" <=", value, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeIn(List<Timestamp> values) {
            addCriterion("\"createdDatetime\" in", values, "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotIn(List<Timestamp> values) {
            addCriterion("\"createdDatetime\" not in", values,
                    "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"createdDatetime\" between", value1, value2,
                    "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andCreatedDatetimeNotBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"createdDatetime\" not between", value1, value2,
                    "createdDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeIsNull() {
            addCriterion("\"updatedDatetime\" is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeIsNotNull() {
            addCriterion("\"updatedDatetime\" is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeEqualTo(Timestamp value) {
            addCriterion("\"updatedDatetime\" =", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeNotEqualTo(Timestamp value) {
            addCriterion("\"updatedDatetime\" <>", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeGreaterThan(Timestamp value) {
            addCriterion("\"updatedDatetime\" >", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeGreaterThanOrEqualTo(Timestamp value) {
            addCriterion("\"updatedDatetime\" >=", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeLessThan(Timestamp value) {
            addCriterion("\"updatedDatetime\" <", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeLessThanOrEqualTo(Timestamp value) {
            addCriterion("\"updatedDatetime\" <=", value, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeIn(List<Timestamp> values) {
            addCriterion("\"updatedDatetime\" in", values, "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeNotIn(List<Timestamp> values) {
            addCriterion("\"updatedDatetime\" not in", values,
                    "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"updatedDatetime\" between", value1, value2,
                    "updatedDatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatedDatetimeNotBetween(Timestamp value1,
                Timestamp value2) {
            addCriterion("\"updatedDatetime\" not between", value1, value2,
                    "updatedDatetime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue,
                String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}