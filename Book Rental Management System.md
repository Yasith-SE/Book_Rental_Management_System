2\. Book Rental Management System



Create a system to manage book rentals for a library or bookstore.



The system should include features to manage books, customers, rental transactions, and

returns.



It should represent a complete, user friendly point of sale experience.

Key Functionalities:



• User authentication and role-based access (admin/staff).

• Book registration with title, author, category, and quantity details.

• Customer registration and profile management.

• Book rental and return process with issue and return dates.

• Calculation of overdue days and fines for late returns.

• Search and filter books or rentals by name, ID, or date.

• Generate rental and return history reports.





**-------------------------------------------------------------------------------------------------**

Include features -> manage books								|

 		 -> customers									|

 		 -> rental transactions								|

 		 -> book returns								|

 												|

 	(user friendly points of sale)								|

 												|

 												|

User authentication>										|

role-based access>										|

 												|

**Book registration**     **->** title, author, category and quantity details				|

**Customer registration ->** with profile management						|

 												|

Book Rental -> return process -> return dates;							|

**calculation of overdue days** - **calculation of fines** for late returns				|

 												|

###### **Search -> ?** filter books and rental book search by id or date	          |

 												|

**-------------------------------------------------------------------------------------------------**



**Book Rental**

 	  -> search

&nbsp; -> Book Id


 	  -> Book title

 	  -> Customer Id

 	  -> Customer Name

 	  -> Book Quantity

 	  -> Book rental cost



Book Returns

 	->Table

 	+--------+------------+-----+---------------+---------------+------------+-------------+

 	|Book Id | Book Title | NIC | Customer Name | Book Quantity | Book price | Book Return |

 	+--------+------------+-----+---------------+---------------+------------+-------------+

 	|\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_\_|

 

 	Overdue days = datechooser

 	Calculations of fines = label



 

