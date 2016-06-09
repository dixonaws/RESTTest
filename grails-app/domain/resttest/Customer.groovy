package resttest

class Customer {
    static hasMany=[accounts:Account]

    // maintained by grails
    Long id
    Long version
    Date dateCreated
    Date lastUpdated

    // our fields
    String customerId
    String firstName
    String lastName

    static constraints = {
    }
}
