namespace WikiSlownikScraper
{
    public class Word
    {
        public string Language1 { get; set; }
        public string Language2 { get; set; }
        public string PhotoUrl { get; set; }

        public Word(string language1, string language2, string photoUrl)
        {
            Language1 = language1;
            Language2 = language2;
            PhotoUrl = photoUrl;
        }
    }
}