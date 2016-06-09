package resttest

class Account {
    static hasMany=[invoices:Invoice]

    // maintained by grails
    Long id
    Long version
    Date dateCreated
    Date lastUpdated

    // our fields
    String accountId
    String serviceAddress
    String serviceCity
    String servicePostalcode
    String serviceCountrycode

    static constraints = {

    }


}
