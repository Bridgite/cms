/**
 * The TrnsltPackageTypeCode entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltPackageTypeCode {
    static mapping = {
         table 'trnslt_package_type_code'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'trnslt_package_type_code_id'
         trnsltPackageTypeCodeId column: 'trnslt_package_type_code_id', updateable: false, insertable: false
   
    }
    Integer trnsltPackageTypeCodeId
    String codeList
    String ecsName
    String code
    String name
    String description

    static constraints = {
        trnsltPackageTypeCodeId(max: 2147483647)
        codeList(size: 0..25)
        ecsName(size: 0..255)
        code(size: 0..5)
        name(size: 0..255)
        description(size: 0..255)
    }
    String toString() {
        return "${trnsltPackageTypeCodeId}" 
    }
}
