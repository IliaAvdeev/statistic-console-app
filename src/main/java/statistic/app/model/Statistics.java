package statistic.app.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public final class Statistics {
    private long maxWeight;
    private long minWeight = Long.MAX_VALUE;
    private Map<DuplicateObjectKey, Long> duplicateObjects = new HashMap<>();
    private Map<String, BigDecimal> indexOfTotalWeightByGroup = new HashMap<>();

    public void accept(ObjectItem objectItem) {
        duplicateObjects.merge(DuplicateObjectKey.of(objectItem), 1L, Long::sum);
        indexOfTotalWeightByGroup.merge(objectItem.getGroup(), new BigDecimal(objectItem.getWeight()), BigDecimal::add);
        maxWeight = Math.max(objectItem.getWeight(), maxWeight);
        minWeight = Math.min(objectItem.getWeight(), minWeight);
    }

    public Map<DuplicateObjectKey, Long> getDuplicateObjects() {
        return duplicateObjects.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(long maxWeight) {
        this.maxWeight = maxWeight;
    }

    public long getMinWeight() {
        return minWeight;
    }

    public void setMinWeight(long minWeight) {
        this.minWeight = minWeight;
    }

    public void setDuplicateObjects(Map<DuplicateObjectKey, Long> duplicateObjects) {
        this.duplicateObjects = duplicateObjects;
    }

    public Map<String, BigDecimal> getIndexOfTotalWeightByGroup() {
        return indexOfTotalWeightByGroup;
    }

    public void setIndexOfTotalWeightByGroup(Map<String, BigDecimal> indexOfTotalWeightByGroup) {
        this.indexOfTotalWeightByGroup = indexOfTotalWeightByGroup;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Statistics other = (Statistics) object;
        return maxWeight == other.maxWeight
                && minWeight == other.minWeight
                && Objects.equals(getDuplicateObjects(), other.getDuplicateObjects())
                && Objects.equals(indexOfTotalWeightByGroup, other.indexOfTotalWeightByGroup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxWeight, minWeight, duplicateObjects, indexOfTotalWeightByGroup);
    }
}