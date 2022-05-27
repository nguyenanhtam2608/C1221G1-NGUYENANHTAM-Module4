use furama_module4;
select h.customer_id as customerID,\n" +
                  k.name_customer customerName,\n" +
                  d.id_service idService,\n" +
                  d.name_service nameService

                   group_concat(distinct dv.name_attach_service SEPARATOR '-') as nameAttachService\n" +
            from contract h\n" +
                     right join customer k on h.customer_id = k.id_customer\n" +
                     right join service d on h.service_id = d.id_service\n" +
                     inner join contract_detail ct on ct.contract_id = h.id_contract\n" +
                     inner join attach_service dv on ct.attach_service_id = dv.id_attach_service
            where name_customer like :customer
            group by h.id_contract;