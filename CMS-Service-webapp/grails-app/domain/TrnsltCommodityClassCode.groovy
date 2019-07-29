/**
 * The TrnsltCommodityClassCode entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltCommodityClassCode {
    static mapping = {
         table 'trnslt_commodity_class_code'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'TRNSLT_COMMODITY_CLASS_CODE_id'
    }
    Integer trnsltCommodityClassCodeId
    String codeList
    String ecsName
    String code
    String name
    String description

    static constraints = {
        trnsltCommodityClassCodeId(max: 2147483647)
        codeList(size: 0..25)
        ecsName(size: 0..255)
        code(size: 0..12)
        name(size: 0..255)
        description(size: 0..255)
    }
    String toString() {
        return "${trnsltCommodityClassCodeId}" 
    }
}
