package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import poc.ncpdp.data.segments.CompoundDTO;

public class Compound extends SegmentBase {
    private final CompoundMapper mapper = new CompoundMapper();
    private CompoundDTO compoundDTO;

    public Compound() {
        super();
        this.compoundDTO = new CompoundDTO();
    }

    public Compound(CompoundDTO compoundDTO) {
        super();
        this.compoundDTO = compoundDTO;
    }

    public static Map<String, String> fieldIdToSymbol() {
        Map<String, String> map = new HashMap<>(SegmentBase.fieldIdToSymbol());
        map.put("EF", "compoundDosageFormDescriptionCode");
        map.put("EG", "compoundDispensingUnitFormIndicator");
        map.put("EC", "compoundIngredientComponentCount");
        map.put("RE", "compoundProductIdQualifier");
        map.put("TE", "compoundProductId");
        map.put("ED", "compoundIngredientQuantity");
        map.put("EE", "compoundIngredientDrugCost");
        map.put("UE", "compoundIngredientBasisOfCostDetermination");
        map.put("2G", "compoundIngredientModifierCodeCount");
        map.put("2H", "compoundIngredientModifierCode");
        return Collections.unmodifiableMap(map);
    }

    public CompoundDTO setDTOValues(Map<String, Object> values) {
        mapper.updateCompoundDTOFromMap(values, compoundDTO);
        setSegmentIdentification(compoundDTO);
        return this.compoundDTO;
    }

    public Map<String, Object> getDTOValues() {
        Map<String, Object> values = new LinkedHashMap<>();
        mapper.updateMapFromCompoundDTO(compoundDTO, values);
        return values;
    }

    private static class CompoundMapper {
        private static final Map<String, BiConsumer<CompoundDTO, String>> FIELD_SETTERS;
        static {
            FIELD_SETTERS = new HashMap<>();
            FIELD_SETTERS.put("EF", (dto, v) -> dto.setCompoundDosageFormDescriptionCode(v));
            FIELD_SETTERS.put("EG", (dto, v) -> dto.setCompoundDispensingUnitFormIndicator(v));
            FIELD_SETTERS.put("EC", (dto, v) -> dto.setCompoundIngredientComponentCount(v));
            FIELD_SETTERS.put("RE", (dto, v) -> dto.setCompoundProductIdQualifier(v));
            FIELD_SETTERS.put("TE", (dto, v) -> dto.setCompoundProductId(v));
            FIELD_SETTERS.put("ED", (dto, v) -> dto.setCompoundIngredientQuantity(v));
            FIELD_SETTERS.put("EE", (dto, v) -> dto.setCompoundIngredientDrugCost(v));
            FIELD_SETTERS.put("UE", (dto, v) -> dto.setCompoundIngredientBasisOfCostDetermination(v));
            FIELD_SETTERS.put("2G", (dto, v) -> dto.setCompoundIngredientModifierCodeCount(v));
            FIELD_SETTERS.put("2H", (dto, v) -> dto.setCompoundIngredientModifierCode(v));
        }

        private static final Map<String, java.util.function.Function<CompoundDTO, Object>> FIELD_GETTERS;
        static {
            FIELD_GETTERS = new LinkedHashMap<>();
            FIELD_GETTERS.put("EF", CompoundDTO::getCompoundDosageFormDescriptionCode);
            FIELD_GETTERS.put("EG", CompoundDTO::getCompoundDispensingUnitFormIndicator);
            FIELD_GETTERS.put("EC", CompoundDTO::getCompoundIngredientComponentCount);
            FIELD_GETTERS.put("RE", CompoundDTO::getCompoundProductIdQualifier);
            FIELD_GETTERS.put("TE", CompoundDTO::getCompoundProductId);
            FIELD_GETTERS.put("ED", CompoundDTO::getCompoundIngredientQuantity);
            FIELD_GETTERS.put("EE", CompoundDTO::getCompoundIngredientDrugCost);
            FIELD_GETTERS.put("UE", CompoundDTO::getCompoundIngredientBasisOfCostDetermination);
            FIELD_GETTERS.put("2G", CompoundDTO::getCompoundIngredientModifierCodeCount);
            FIELD_GETTERS.put("2H", CompoundDTO::getCompoundIngredientModifierCode);
        }

        public void updateCompoundDTOFromMap(Map<String, Object> values, CompoundDTO dto) {
            values.forEach((key, value) -> {
                BiConsumer<CompoundDTO, String> setter = FIELD_SETTERS.get(key);
                if (setter != null) {
                    setter.accept(dto, value != null ? value.toString() : null);
                }
            });
        }

        public void updateMapFromCompoundDTO(CompoundDTO dto, Map<String, Object> values) {
            SegmentBase.setSegmentIdentification(values, dto.getSegmentIdentification());
            FIELD_GETTERS.forEach((key, getter) -> {
                Object value = getter.apply(dto);
                if (value != null) {
                    values.put(key, value);
                }
            });
        }
    }
}
