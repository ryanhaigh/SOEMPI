/**
 * 
 *  Copyright (C) 2013 Vanderbilt University <csaba.toth, b.malin @vanderbilt.edu>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */
package org.openhie.openempi.dao;

import java.util.List;

import org.openhie.openempi.model.MatchPairStatHalf;
import org.springframework.transaction.annotation.Transactional;

public interface MatchPairStatHalfDao extends UniversalDao
{
	/**
	 * Creates a table where match pair stats will can be stored.
	 * The tableName will get a "tbl_matchpairstathalf_" prefix.
	 * The table will have a primary key column automatically, a sequence will be created for that
	 * column and the table will be indexed by that also.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 * @param datasetTableName: table name of the associated dataset
	 * @param withIndexesAndConstraints: will apply indexes and constraints right after table creation
	 * or it'll be done by the user later with an addIndexesAndConstraints call
	 */
    @Transactional
	public void createTable(final String tableName, final String datasetTableName,
			final boolean withIndexesAndConstraints);

	/**
	 * Create a table where certain match pair stats can be be stored.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 */
    @Transactional
	public void removeTable(final String tableName);

	/**
	 * Add a MatchPairStatHalf entity to the table.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 * @param matchPairStatHalf: the MatchPairStatHalf entity to be added
	 */
	public void addMatchPairStatHalf(final String tableName, final MatchPairStatHalf matchPairStatHalf);
	
	/**
	 * Add more MatchPairStatHalf entities to the table in a batch with one call.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 * @param matchPairStatHalves: list of the MatchPairStatHalf entities to be added
	 */
	public void addMatchPairStatHalves(final String tableName, final List<MatchPairStatHalf> matchPairStatHalves);

	/**
	 * Add indexes and constraints to the previously created table.
	 * "withIndexesAndConstraints" must have been false before during createTable call.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 * @param seqStart: starting value the created sequence should start from
	 * @param datasetTableName: table name of the associated dataset
	 */
    @Transactional
	public void addIndexesAndConstraints(final String tableName, final long seqStart, final String datasetTableName);

	/**
	 * Update an existing MatchPairStatHalf entity in the table.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 * @param matchPairStatHalf: the MatchPairStatHalf entity to be updated
	 */
    @Transactional
	public void updateMatchPairStatHalf(final String tableName, final MatchPairStatHalf matchPairStatHalf);
	
	/**
	 * Query MatchPairStatHalf entities from a given table in a paged manner.
	 * 
	 * @param tableName: name of the table, will get "tbl_matchpairstathalf_" prefix
	 * @param firstResult: first entity in the order to see
	 * @param maxResults: number of entities we want to query
	 * 
	 * @return MatchPairStatHalf entities fulfilling the query criteria
	 */
	public List<MatchPairStatHalf> getMatchPairStatHalvesPaged(final String tableName, final long firstResult,
			final int maxResults);
}
