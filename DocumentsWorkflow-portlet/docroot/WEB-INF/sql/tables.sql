create table docs_Document (
	uuid_ VARCHAR(75) null,
	documentId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	title VARCHAR(75) null,
	type_ VARCHAR(75) null,
	status INTEGER
);

create table docs_History (
	logId LONG not null primary key,
	documentId LONG,
	userId LONG,
	status VARCHAR(75) null,
	updatedDate DATE null,
	comment_ VARCHAR(75) null
);