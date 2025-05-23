package poc.ncpdp.parser.segments;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import poc.ncpdp.data.segments.CompoundDTO;

public class Compound extends SegmentBase {
    private final CompoundMapper mapper = new CompoundMapper();
    private CompoundDTO compoundDTO;

    public Compound() {
        super();
        this.compoundDTO = new CompoundDTO();
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
        return this.compoundDTO;
    }

    private class CompoundMapper {
        public void updateCompoundDTOFromMap(Map<String, Object> values, CompoundDTO dto) {
            for (Map.Entry<String, Object> entry : values.entrySet()) {
                String value = entry.getValue() != null ? entry.getValue().toString() : null;
                switch (entry.getKey()) {
                    case "EF": dto.setCompoundDosageFormDescriptionCode(value); break;
                    case "EG": dto.setCompoundDispensingUnitFormIndicator(value); break;
                    case "EC": dto.setCompoundIngredientComponentCount(value); break;
                    case "RE": dto.setCompoundProductIdQualifier(value); break;
                    case "TE": dto.setCompoundProductId(value); break;
                    case "ED": dto.setCompoundIngredientQuantity(value); break;
                    case "EE": dto.setCompoundIngredientDrugCost(value); break;
                    case "UE": dto.setCompoundIngredientBasisOfCostDetermination(value); break;
                    case "2G": dto.setCompoundIngredientModifierCodeCount(value); break;
                    case "2H": dto.setCompoundIngredientModifierCode(value); break;
                }
            }
        }
    }
}
