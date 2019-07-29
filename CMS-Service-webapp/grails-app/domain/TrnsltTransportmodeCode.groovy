/**
 * The TrnsltTransportmodeCode entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltTransportmodeCode {
    static mapping = {
         table 'trnslt_transportmode_code'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'trnslt_transportmode_code_id'
         trnsltTransportmodeCodeId column: 'trnslt_transportmode_code_id', updateable: false, insertable: false
   
    }
    Integer trnsltTransportmodeCodeId
    String codeList
    Integer ecsName
    Integer code
    String name
    String description

    static constraints = {
        trnsltTransportmodeCodeId(max: 2147483647)
        codeList(size: 0..25)
        ecsName(nullable: true, max: 2147483647)
        code(nullable: true, max: 2147483647)
        name(size: 0..45)
        description(size: 0..255)
    }
    String toString() {
        return "${trnsltTransportmodeCodeId}" 
    }
}
