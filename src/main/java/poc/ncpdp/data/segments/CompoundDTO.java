package poc.ncpdp.data.segments;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CompoundDTO extends SegmentDTO {
    private String compoundDosageFormDescriptionCode;
    private String compoundDispensingUnitFormIndicator;
    private String compoundIngredientComponentCount;
    private String compoundProductIdQualifier;
    private String compoundProductId;
    private String compoundIngredientQuantity;
    private String compoundIngredientDrugCost;
    private String compoundIngredientBasisOfCostDetermination;
    private String compoundIngredientModifierCodeCount;
    private String compoundIngredientModifierCode;
}
