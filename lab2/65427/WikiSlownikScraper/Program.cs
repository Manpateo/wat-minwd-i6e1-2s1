using System;
using System.Linq;
using System.Net.Http;
using HtmlAgilityPack;

namespace WikiSlownikScraper
{
    class Program
    {
        static void Main(string[] args)
        {
            HtmlReader.ReadSite("https://pl.wiktionary.org/wiki/Indeks:Angielski_-_Ssaki?fbclid=IwAR3RVwyFUYg8l86yGkg4OPu9MRZr4S3Vi8bc5SxYVN-2jeyvUvSgHXnpcyI");
            Console.ReadLine();
        }
    }
}
