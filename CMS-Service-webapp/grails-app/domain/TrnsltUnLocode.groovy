/**
 * The TrnsltUnLocode entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltUnLocode {
    static mapping = {
        table 'trnslt_un_locode'
        // version is set to false, because this isn't available by default for legacy databases
        version false
        id generator:'identity', column:'trnslt_un_locode_id' 
        trnsltUnLocodeId column: 'trnslt_un_locode_id', updateable: false, insertable: false
   
         
    }
    Integer trnsltUnLocodeId
    String codeList
    String ecsName
    String code
    String iso
    String city
    String nameDiacritic

    static constraints = {
        trnsltUnLocodeId(max: 2147483647)
        codeList(size: 0..12)
        ecsName(size: 0..255)
        code(size: 0..5)
        iso(size: 0..5)
        city(size: 0..5)
        nameDiacritic(size: 0..255)
    }
    String toString() {
        return "${trnsltUnLocodeId}" 
    }
}
