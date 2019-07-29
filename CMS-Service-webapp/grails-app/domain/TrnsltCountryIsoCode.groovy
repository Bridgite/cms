/**
 * The TrnsltCountryIsoCode entity.
 *
 * @author  Bobby Kimutai  Chrimoska
 *
 *
 */
class TrnsltCountryIsoCode {
    static mapping = {
         table 'trnslt_country_iso_code'
         // version is set to false, because this isn't available by default for legacy databases
         version false
         id generator:'identity', column:'trnslt_country_iso_code_id'
         trnsltCountryIsoCodeId column: 'trnslt_country_iso_code_id', updateable: false, insertable: false
   
    }
    Integer trnsltCountryIsoCodeId
    String ecsName
    String isoCode
    String description
    Integer primaryKeyColumn
    String twoCharIsoCode

    static constraints = {
        trnsltCountryIsoCodeId(max: 2147483647)
        ecsName(size: 0..45)
        isoCode(size: 1..5, blank: false)
        description(size: 0..45)
        primaryKeyColumn(max: 2147483647)
        twoCharIsoCode(size: 1..5, blank: false)
    }
    String toString() {
        return "${trnsltCountryIsoCodeId}" 
    }
}
