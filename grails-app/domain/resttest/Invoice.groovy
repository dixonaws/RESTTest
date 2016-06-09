package resttest
// Annotating the class is one way to define this domain object as a RESTful service
// @Resource(uri='/invoices', formats=['json', 'xml', 'text'], readOnly=false)

class Invoice {
    // maintained by grails
    Long id
    Long version
    Date dateCreated
    Date lastUpdated

    // our fields
    String invoiceId
    String accountId
    String customerId
    Date servicePeriodStart
    Date servicePeriodEnd
    int amountDollars
    int amountCents
    int currentMeterReading
    int previousMeterReading

    static constraints = {
        invoiceId blank:false, nullable: false
        accountId blank: false, nullable: false
        customerId blank: false, nullable: false
        servicePeriodStart blank: false, nullable: false
        servicePeriodEnd blank: false, nullable: false
        amountDollars blank: false, nullable: false
        amountCents blank:false, nullable: false
        currentMeterReading blank: true, nullable: true
        previousMeterReading blank: true, nullable: true

    } // constraints


}
