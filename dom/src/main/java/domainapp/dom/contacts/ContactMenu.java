package domainapp.dom.contacts;

import domainapp.dom.group.ContactGroup;
import org.apache.isis.applib.annotation.*;

@DomainService(
        nature = NatureOfService.VIEW_MENU_ONLY
)
@DomainServiceLayout(
        named = "Contacts",
        menuOrder = "1"
)
public class ContactMenu {

    @Action(
            semantics = SemanticsOf.SAFE,
            restrictTo = RestrictTo.PROTOTYPING
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "1")
    public java.util.List<Contact> listAll() {
        return contactrepository.listAll();
    }

    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "2")
    public java.util.List<Contact> findByName(
            final String name
    ) {
        return contactrepository.findByNameContains(name);
    }

    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "3")
    public java.util.List<Contact> findByGroup(
            final ContactGroup group
    ) {
        return contactrepository.findByContactGroup(group);
    }

    @Action(
            semantics = SemanticsOf.SAFE
    )
    @ActionLayout(
            bookmarking = BookmarkPolicy.AS_ROOT
    )
    @MemberOrder(sequence = "4")
    public java.util.List<Contact> findByRole(
            final String roleName
    ) {
        return contactrepository.findByContactRoleNameContains(roleName);
    }

    @Action(
    )
    @MemberOrder(sequence = "5")
    public Contact create(
            final String name,
            @Parameter(optionality = Optionality.OPTIONAL)
            final String company,
            @Parameter(optionality = Optionality.OPTIONAL)
            final String officeNumber,
            @Parameter(optionality = Optionality.OPTIONAL)
            final String mobileNumber,
            @Parameter(optionality = Optionality.OPTIONAL)
            final String homeNumber,
            @Parameter(optionality = Optionality.OPTIONAL)
            final String email) {
        return contactrepository.create(name, company, email, null, officeNumber, mobileNumber, homeNumber);
    }

    @javax.inject.Inject
    ContactRepository contactrepository;
}
