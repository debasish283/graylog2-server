/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog2.rest.models.tools.responses;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@JsonAutoDetect
@AutoValue
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class ContainsStringTesterResponse {
    @JsonProperty("matched")
    public abstract boolean matched();

    @JsonProperty("match")
    @Nullable
    public abstract Match match();

    @JsonProperty("search_string")
    public abstract String searchString();

    @JsonProperty("string")
    public abstract String string();

    @JsonCreator
    public static ContainsStringTesterResponse create(@JsonProperty("matched") boolean matched,
                                                      @JsonProperty("match") @Nullable Match match,
                                                      @JsonProperty("search_string") String searchString,
                                                      @JsonProperty("string") String string) {
        return new AutoValue_ContainsStringTesterResponse(matched, match, searchString, string);
    }

    @JsonAutoDetect
    @AutoValue
    public static abstract class Match {
        @JsonProperty
        public abstract int start();

        @JsonProperty
        public abstract int end();

        @JsonCreator
        public static Match create(@JsonProperty("start") int start,
                                   @JsonProperty("end") int end) {
            return new AutoValue_ContainsStringTesterResponse_Match(start, end);
        }
    }
}
