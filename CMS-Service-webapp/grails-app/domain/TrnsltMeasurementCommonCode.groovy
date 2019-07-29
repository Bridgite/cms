/**
 * The TrnsltMeasurementCommonCode entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltMeasurementCommonCode {
    static mapping = {
         table 'trnslt_measurement_common_code'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'trnslt_measurement_common_code_id'
         trnsltMeasurementCommonCodeId column: 'trnslt_measurement_common_code_id', updateable: false, insertable: false
   
    }
    Integer trnsltMeasurementCommonCodeId
    String codeList
    String ecsName
    String code
    String name
    String description

    static constraints = {
        trnsltMeasurementCommonCodeId(max: 2147483647)
        codeList(size: 0..25)
        ecsName(size: 0..255)
        code(size: 0..5)
        name(size: 0..255)
        description(size: 0..500)
    }
    String toString() {
        return "${trnsltMeasurementCommonCodeId}" 
    }
}
