import androidx.room.Dao
import androidx.room.Query
import com.example.basketballcounter.Game

@Dao
interface GameDao {

    @Query("SELECT * from game")
    fun getGames(): List<Game>

    @Query("SELECT * from game where scoreA > scoreB")
    fun getAWins(): List<Game>

    @Query("SELECT * from game where scoreB > scoreA")
    fun getBWins(): List<Game>
}