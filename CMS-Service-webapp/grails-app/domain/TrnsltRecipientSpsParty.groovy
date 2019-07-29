/**
 * The TrnsltRecipientSpsParty entity.
 *
 * @author  KIM  
 *
 *
 */
class TrnsltRecipientSpsParty {
    static mapping = {
         table 'trnslt_recipient_sps_party'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'trnslt_recipient_sps_party_id'
         trnsltRecipientSpsPartyId column: 'trnslt_recipient_sps_party_id', updateable: false, insertable: false
    }
    Integer trnsltRecipientSpsPartyId
    String codeList
    String ecsName
    String code
    String name
    String description

    static constraints = {
        trnsltRecipientSpsPartyId(max: 2147483647)
        codeList(size: 0..25)
        ecsName(size: 0..255)
        code(size: 0..5)
        name(size: 0..255)
        description(size: 0..255)
    }
    String toString() {
        return "${trnsltRecipientSpsPartyId}" 
    }
}
