package com.example.reposirory.customer;

import com.example.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContaining(String searchName, String searchAddress, Pageable pageable);

    Page<Customer> findAllByCustomerNameContainingAndCustomerAddressContainingAndCustomerType_CustomerTypeId(String searchName, String searchAddress, int searchCategory, Pageable pageable);

//    @Query (value = "select contract.contract_id, customer.customer_name, service.service_name, service.description_other_convenience, service.service_cost, \n" +
//                    "attach_service.attach_service_name, contract_detail.quantity\n" +
//                    "from customer\n" +
//                    "inner join contract on customer.customer_id = contract.customer_id\n" +
//                    "inner join service on contract.service_id = service.service_id\n" +
//                    "left join contract_detail on contract.contract_id = contract_detail.contract_id\n" +
//                    "left join attach_service on contract_detail.attach_service_id = attach_service.attach_service_id\n" +
//                    "where now() between contract.contract_start_date and contract.contract_end_date", nativeQuery = true)
//    List<ServiceNowDto> getTry ();
}
