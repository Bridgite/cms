/**
 * The TrnsltEpptBotanicalName entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltEpptBotanicalName {
    static mapping = {
         table 'trnslt_eppt_botanical_name'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'trnslt_eppt_botanical_name_id'
         trnsltEpptBotanicalNameId column: 'trnslt_eppt_botanical_name_id', updateable: false, insertable: false
   
    }
    Integer trnsltEpptBotanicalNameId
    String codeList
    String ecsName
    String code
    String fullName
    String authority
    String identifier
    String datatype
    String lang
    Integer langno
    Integer preferred
    String status
    Date creation
    Date modification
    String country

    static constraints = {
        trnsltEpptBotanicalNameId(max: 2147483647)
        codeList(size: 0..25)
        ecsName(size: 0..45)
        code(size: 0..20)
        fullName(size: 0..255)
        authority(size: 0..255)
        identifier(size: 0..12)
        datatype(size: 0..5)
        lang(size: 0..5)
        langno(nullable: true, max: 2147483647)
        preferred(nullable: true, max: 2147483647)
        status(size: 0..5)
        creation(nullable: true)
        modification(nullable: true)
        country(size: 0..255)
    }
    String toString() {
        return "${trnsltEpptBotanicalNameId}" 
    }
}
