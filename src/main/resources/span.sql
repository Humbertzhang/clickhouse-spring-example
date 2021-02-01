CREATE TABLE spans \
( \
	`spanId` 				String, \
	`traceId` 			String, \
	`pathId` 				Int64, \
	`operationName` String, \
	`serviceName` 	String, \
	`podIp` 				IPv4, \
	`requestName` 	String, \
	`spanLayer` 		String, \
	`startTime` 		UInt64, \
	`endTime` 			UInt64, \
	`tags` 					String \
) ENGINE = MergeTree() \
ORDER BY traceId;

INSERT INTO spans \
    (spanId, traceId, pathId, operationName, serviceName, podIp, requestName, SpanLayer, StartTime, EndTime, Tags) \
VALUES ('ed9e341b73e94b6e97f2e98807a6ca3b.41.16116645268210000.1', 'be27038dc82548539b7947fff8603235.39.16116645267630003', -1120152918, 'MongoDB/FindOperation', 'alias.ts-travel-mongo:27017', '127.0.0.1', 'BuyTicket', 'Exit', 1611664526826, 1611664526827, '{"@class": "java.util.HashMap","db.type": "MongoDB","db.statement": "FindOperation { \"_id\" : { \"type\" : \"D\", \"number\" : \"1345\" } }"}');
