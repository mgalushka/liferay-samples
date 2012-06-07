create index IX_D9A564A3 on docs_Document (title);
create index IX_22670B4F on docs_Document (uuid_);
create unique index IX_CE84B23B on docs_Document (uuid_, groupId);

create index IX_CE1185C0 on docs_History (documentId);